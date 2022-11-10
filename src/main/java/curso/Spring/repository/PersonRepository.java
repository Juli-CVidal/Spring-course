package curso.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.Spring.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,String>{
	
//	@Query("SELECT p FROM person p")
//	public List<Person> getAllPersons();
}
