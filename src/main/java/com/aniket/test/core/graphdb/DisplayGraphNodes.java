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
@ConditionalOnProperty(name = "runner.displayGraphNodes.enabled", havingValue = "true")
public class DisplayGraphNodes implements CommandLineRunner {

	@Autowired
	Driver driver;


	public static void main(String[] args) {
		System.out.println("Staring GraphDB App");
		SpringApplication.run(DisplayGraphNodes.class, args);
	}


	@Override
	public void run(String... args) throws Exception{
		try(var session= driver.session()){
			System.out.println("Staring GraphDB session..");
			session.run("match (n) return n.link as link limit 30").list().forEach( r -> {
					System.out.println(r.get("link"));
				}
			);
		}
	}

}

