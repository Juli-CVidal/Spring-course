package curso.Spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.Spring.entities.Person;
import curso.Spring.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("/add")
	public String add(Person person) {
		return "create_modify";
	}

	@PostMapping("/save")
	public String save(@Valid Person person, Errors error,ModelMap model) {
		if (error.hasErrors()) {
			model.put("person", person);
			return "create_modify";
		}
		service.save(person);
		return "redirect:/";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(Person person, ModelMap model) {
		person = service.findById(person.getId());
		model.put("person", person);
		return "create_modify";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Person person) {
		service.delete(person);
		return "redirect:/";
	}

}
