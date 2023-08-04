package br.com.carvalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carvalho.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
