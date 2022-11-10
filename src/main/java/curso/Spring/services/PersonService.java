package curso.Spring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.Spring.entities.Person;
import curso.Spring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> getAllPersons() {
		return repository.findAll();
	}

	@Transactional
	public void save(Person person) {
		repository.save(person);
	}
	
	@Transactional
	public void delete(Person person) {
		repository.delete(person);
	}
	
	@Transactional(readOnly = true)
	public Person findById(String id) {
		return repository.findById(id).orElse(null);
	}
}