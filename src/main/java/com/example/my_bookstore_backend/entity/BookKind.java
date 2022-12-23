package com.example.my_bookstore_backend.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Node
public class BookKind {
    @Id
    @GeneratedValue
    private Long id;
    private String kind;

    private BookKind() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public BookKind(String kind) {
        this.kind = kind;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "NEIGHBOR")
    public Set<BookKind> neighbors;

    public void neighborWith(BookKind bookKind) {
        if (neighbors == null) {
            neighbors = new HashSet<>();
        }
        neighbors.add(bookKind);
    }

    public String toString() {

        return this.kind + "'s neighbors => "
                + Optional.ofNullable(this.neighbors).orElse(
                        Collections.emptySet()).stream()
                .map(BookKind::getKind)
                .collect(Collectors.toList());
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
