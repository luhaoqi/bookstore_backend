package com.example.my_bookstore_backend.repository;

import com.example.my_bookstore_backend.entity.BookKind;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface BookKindRespository extends Neo4jRepository<BookKind, Long> {
    BookKind findByKind(String kind);

    @Query("MATCH (b1:BookKind)-[*1..1]-(b2:BookKind) WHERE b1.kind = $name RETURN DISTINCT b2 \n")
    List<BookKind> findOneStepNeighbor(String name);

    @Query("MATCH (b1:BookKind)-[*1..2]-(b2:BookKind) WHERE b1.kind = $name RETURN DISTINCT b2 \n")
    List<BookKind> findTowStepNeighbor(String name);
}
