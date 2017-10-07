package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class authorApplication {
	
	@Autowired
    private SeedData seedData;
	
    public static void main(String[] args) {
    	SpringApplication.run(authorApplication.class, args);
    }

}