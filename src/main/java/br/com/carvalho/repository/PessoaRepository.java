package br.com.carvalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carvalho.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findByEmail(String email);
}
