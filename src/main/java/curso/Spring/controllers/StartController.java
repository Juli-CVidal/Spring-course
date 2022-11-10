package curso.Spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import curso.Spring.entities.Person;
import curso.Spring.services.PersonService;

@Controller
public class StartController {


	@Autowired 
	private PersonService service;

	@GetMapping("/")
	public String start(ModelMap model) {
	
		
		List<Person> persons = service.getAllPersons();
		String mensaje = "Soy un mensaje";
		model.put("persons", persons);
		model.put("mensaje", mensaje);
		return "index";
	}
	
}