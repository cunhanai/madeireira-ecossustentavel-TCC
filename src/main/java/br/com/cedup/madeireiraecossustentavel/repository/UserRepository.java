package br.com.cedup.madeireiraecossustentavel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cedup.madeireiraecossustentavel.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByLogin(String login);

}
