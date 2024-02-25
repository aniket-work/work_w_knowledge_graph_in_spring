package com.aniket.test.core.graphdb;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.StringJoiner;

@Node("Tag")
public class Tag {
   /* @Id
    @GeneratedValue
    Long id;*/

    @Id
    public final String name;


    public Tag(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
