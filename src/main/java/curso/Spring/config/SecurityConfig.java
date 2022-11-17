package curso.Spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("ADMIN").password("{noop}admin").roles("ADMIN","USER")
			.and().withUser("USER").password("{noop}user").roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/person/**").hasRole("ADMIN")
		.antMatchers("/").hasAnyRole("USER","ADMIN")
		.and()
		.formLogin().loginPage("/login")
		.and()
		.exceptionHandling().accessDeniedPage("/errors/403");
	}
	
}
