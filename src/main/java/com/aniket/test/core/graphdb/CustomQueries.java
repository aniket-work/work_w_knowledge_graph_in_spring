package com.aniket.test.core.graphdb;

import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootApplication
@EnableNeo4jRepositories(considerNestedRepositories = true)
@ConditionalOnProperty(name = "runner.customQuery.enabled", havingValue = "true")
public class CustomQueries implements CommandLineRunner {

	@Autowired
	Driver driver;

	@Autowired
	CustomQuestionRepository questionRepository;

	public static void main(String[] args) {
		System.out.println("Staring GraphDB App");
		SpringApplication.run(CustomQueries.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Question> questions = questionRepository.getAllQuesWAnswers(3);
		questions.forEach(System.out::println);
	}

	interface CustomQuestionRepository extends Neo4jRepository<Question, String> {

		@Query("match (n:Question) where n.answer_count >= $ansCount return n")
		List<Question> getAllQuesWAnswers(@Param("ansCount") Integer ansCount );
	}

}

