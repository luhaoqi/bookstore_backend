package com.example.my_bookstore_backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.my_bookstore_backend.entity.Book;
import com.example.my_bookstore_backend.repository.BookRepository;
import com.example.my_bookstore_backend.service.BookService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

//永远不要返回null 做好特判
@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public int addNewBook(@RequestParam String name, @RequestParam String author,
                          @RequestParam int price, @RequestParam String image,
                          @RequestParam String description, @RequestParam String isbn,
                          @RequestParam int sales, @RequestParam int stock,
                          @RequestParam String iconBase64) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        book.setSales(sales);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setStock(stock);
        book.setFlag(1);
        bookService.save(book, iconBase64);
        return book.getBid();
    }

    @PostMapping(path = "/edit")
    public Book editBook(@RequestParam int bid,
                         @RequestParam(required = false) String name, @RequestParam(required = false) String author,
                         @RequestParam(required = false) Integer price, @RequestParam(required = false) String image,
                         @RequestParam(required = false) String description, @RequestParam(required = false) String isbn,
                         @RequestParam(required = false) Integer sales, @RequestParam(required = false) Integer stock,
                         @RequestParam(required = false) Integer flag, @RequestParam String iconBase64) {
        Book book = bookService.getBookById(bid);
        if (book == null) {
            Book nullBook = new Book();
            nullBook.setBid(0);
            return nullBook;
        }
        if (name != null) book.setName(name);
        if (author != null) book.setAuthor(author);
        if (price != null) book.setPrice(price);
        if (image != null) book.setImage(image);
        if (description != null) book.setDescription(description);
        if (isbn != null) book.setIsbn(isbn);
        if (sales != null) book.setSales(sales);
        if (stock != null) book.setStock(stock);
        if (flag != null) book.setFlag(flag);
        bookService.save(book, iconBase64);
        return book;
    }

    @PostMapping(path = "/delete")
    public int editBook(@RequestParam int bid) {
        Book book = bookService.getBookById(bid);
        if (book != null) {
            bookService.delete(book);
            return 1;
        }
        return 0;
    }

    @GetMapping("/all")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/kind")
    public List<Book> getBooksByKind(String kind) {
        return bookRepository.findBooksByKind(kind);
    }

    @GetMapping("/name")
    public Book getBooksByName(String name) {
        Book b = bookRepository.findBookByName(name);
        if (b != null) return b;
        b = new Book();
        b.setName("null");
        return b;
    }

    @PostMapping("/search")
    public Book getBookByID(@RequestParam("id") Integer id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            Book nullBook = new Book();
            nullBook.setBid(0);
            return nullBook;
        }
        return book;
    }

    @PostMapping("/filter")
    public List<JSONObject> getBooksByFilter(@RequestParam("key") String key) throws SolrServerException, IOException {
        final SolrClient client = getSolrClient();
        final Map<String, String> queryParamMap = new HashMap<String, String>();
        //一次十个
        queryParamMap.put("q", "description:" + (!Objects.equals(key, "") ? key : "*"));
        queryParamMap.put("sort", "id asc");
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response = client.query("bookstore", queryParams);
        final SolrDocumentList documents = response.getResults();
        List<JSONObject> list = new ArrayList<>();
        System.out.println("Found " + documents.getNumFound() + " documents");
        for (SolrDocument document : documents) {
            final String id = (String) document.getFirstValue("id");
            final String name = (String) document.getFirstValue("name");
            final String author = (String) document.getFirstValue("author");
            final String description = (String) document.getFirstValue("description");
            JSONObject o = new JSONObject();
            o.put("id", id);
            o.put("name", name);
            o.put("author", author);
            o.put("description", description);
            list.add(o);
        }
        return list;
    }

    @GetMapping("/solr/indexed")
    public void indexBooks() throws SolrServerException, IOException {
        List<Book> list = bookService.getAllBooks();
        final SolrClient client = getSolrClient();
        for (Book b : list) {
            final UpdateResponse response = client.addBean("bookstore", b);
        }
        client.commit("bookstore");
    }

    public static SolrClient getSolrClient() {
        final String solrUrl = "http://localhost:8983/solr";
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }
}
