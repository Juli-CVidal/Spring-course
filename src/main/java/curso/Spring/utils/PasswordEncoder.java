package curso.Spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	@Autowired
	private static final BCryptPasswordEncoder pswdEncoder = new BCryptPasswordEncoder();
	
	public static String encode(String pass) {
		return pswdEncoder.encode(pass);
	}
}
