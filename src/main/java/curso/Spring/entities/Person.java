package curso.Spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotEmpty(message = "A name is required")
	private String name;

	@NotEmpty(message = "A lastname is required")
	private String lastname;

	@NotEmpty(message = "An email is required")
	@Email(message = "Please enter a valid email")
	private String email;
	private String number;
}
