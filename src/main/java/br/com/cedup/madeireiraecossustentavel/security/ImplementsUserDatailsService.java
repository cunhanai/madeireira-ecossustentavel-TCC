package br.com.cedup.madeireiraecossustentavel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cedup.madeireiraecossustentavel.models.User;
import br.com.cedup.madeireiraecossustentavel.repository.UserRepository;

@Repository
public class ImplementsUserDatailsService implements UserDetailsService {

	@Autowired
	private UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = ur.findByLogin(login);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado!");
		}
		
		return user;
	}
	
	
}
