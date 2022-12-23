package com.example.my_bookstore_backend.controller;

import com.example.my_bookstore_backend.entity.BookKind;
import com.example.my_bookstore_backend.repository.BookKindRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/bookkind")
public class BookKindController {
    @Autowired
    private BookKindRespository bookKindRespository;

    @GetMapping(path = "/find_neighbor_one_step")
    List<BookKind> getNeighborOne(String kind){
        return bookKindRespository.findOneStepNeighbor(kind);
    }

    @GetMapping(path = "/find_neighbor_tow_step")
    List<BookKind> getNeighborTow(String kind){
        return bookKindRespository.findTowStepNeighbor(kind);
    }

    @GetMapping(path = "/test")
    void test(){
        bookKindRespository.deleteAll();

        BookKind b1 = new BookKind("科幻");
        BookKind b2 = new BookKind("小说");
        BookKind b3 = new BookKind("童话");
        BookKind b4 = new BookKind("心理学");
        BookKind b5 = new BookKind("哲学");
        BookKind b6 = new BookKind("成功学");

        bookKindRespository.save(b1);
        bookKindRespository.save(b2);
        bookKindRespository.save(b3);
        bookKindRespository.save(b4);
        bookKindRespository.save(b5);
        bookKindRespository.save(b6);

        b1.neighborWith(b2);
        b1.neighborWith(b4);
        bookKindRespository.save(b1);

        b2.neighborWith(b3);
        bookKindRespository.save(b2);

        b4.neighborWith(b5);
        b4.neighborWith(b6);
        bookKindRespository.save(b4);

    }
}
