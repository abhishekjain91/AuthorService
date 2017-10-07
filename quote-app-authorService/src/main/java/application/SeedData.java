package application;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.model.authorModel;
import application.service.authorService;

@Configuration
public class SeedData {

    @Autowired
    private authorService authorService1;
   
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    public SeedData getBean() throws SQLException {
    	
        
    	authorModel a1 = new authorModel("Douglas Adams");
    	authorModel a2 = new authorModel("Gautama Buddha");
    	authorModel a3 = new authorModel("Albert Einstein");
        
    	authorService1.save(a1);
    	authorService1.save(a2);
    	authorService1.save(a3);
        return new SeedData();
    }
}
