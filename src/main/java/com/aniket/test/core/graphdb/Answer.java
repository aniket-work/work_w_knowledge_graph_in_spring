package com.aniket.test.core.graphdb;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Answer")
public class Answer {

    @Id
    @GeneratedValue
    Long id;
}
