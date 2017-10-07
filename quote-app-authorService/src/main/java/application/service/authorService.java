package application.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import application.model.authorModel;

@Service
public interface authorService extends CrudRepository<authorModel, Long> {
	
	authorModel findByName(String name);
}
