package com.aniket.test.core.graphdb;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.StringJoiner;

@Node("Question")
public class Question {

    @Id
    public final String title;

    @Property("answer_count")
    public final Integer quesWAnswerCount;

    public Question(String title, Integer quesWAnswerCount, List<Tag> tags) {
        this.title = title;
        this.quesWAnswerCount = quesWAnswerCount;
        this.tags = tags;
    }

    @Relationship("TAGGED")
    public final List<Tag> tags;

    @Override
    public String toString() {
        return new StringJoiner(", ", Question.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("quesWAnswerCount=" + quesWAnswerCount)
                .add("tags=" + tags)
                .toString();
    }
}
