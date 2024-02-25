package com.aniket.test.core.graphdb;

import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(considerNestedRepositories = true)
@ConditionalOnProperty(name = "runner.fetchNodeRelationship.enabled", havingValue = "true")
public class FetchNodeRelationship implements CommandLineRunner {

	@Autowired
	Driver driver;

	@Autowired
	QuestionRepository questionRepository;

	public static void main(String[] args) {
		System.out.println("Staring GraphDB App");
		SpringApplication.run(FetchNodeRelationship.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Question question = questionRepository.findById("How to save multiple labels of a node in neo4j in a specified order?").get();
		System.out.println("question is ::  " + question);
		question.tags.forEach(t -> System.out.println(t));

	}

	interface QuestionRepository extends Neo4jRepository<Question, String> {}

}

