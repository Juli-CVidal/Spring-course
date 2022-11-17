package curso.Spring.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.Spring.entities.AccountUser;
import curso.Spring.repository.UserRepository;

@Service("userDetailsService")
public class AccountUserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountUser user = repository.findByUsername(username);
		
		if (null == user) {
			throw new UsernameNotFoundException("The user has not been found");
		}
		
		List<GrantedAuthority> grantedAuth = new ArrayList();
		user.getRoles().forEach(role -> grantedAuth.add(new SimpleGrantedAuthority(role.getName())));
		return new User(user.getUsername(),user.getPassword(),grantedAuth);
	}
	
}
