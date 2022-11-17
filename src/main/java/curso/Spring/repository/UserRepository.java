package curso.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.Spring.entities.AccountUser;

public interface UserRepository extends JpaRepository<AccountUser,Integer>{
	 public AccountUser findByUsername(String username);
}
