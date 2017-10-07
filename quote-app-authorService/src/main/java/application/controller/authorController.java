package application.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.model.authorModel;
import application.service.authorService;

@RestController
public class authorController {

	@Autowired
    private authorService authorService;
    
	// This is to map the incoming request in the URL to this controller.
	// This indirectly call the service and fetches the quotes according to the author.
    @RequestMapping("api/author/{id}")
	public authorModel getAuthor(@PathVariable("id") long id) {
    	System.out.println("Get author and his quotes");
    	authorModel authors = this.authorService.findOne(id);
		return authors;
	}
    
    // Search auhor by name, used in case of new quote
    @RequestMapping("api/author/name/{authName}")
	public authorModel getAuthName(@PathVariable("authName") String authName) {
    	authorModel author = this.authorService.findByName(authName);
		return author;
	}
    
    // Save the new author
    @RequestMapping(value = "api/author", method = RequestMethod.POST)
	public long saveAuthor(@RequestBody authorModel author) {
    	authorService.save(author);
    	return getAuthName(author.getName()).getId();
	}
    
}
