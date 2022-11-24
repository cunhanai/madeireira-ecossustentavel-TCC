package br.com.cedup.madeireiraecossustentavel.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
@SuppressWarnings("serial")
public class Role implements GrantedAuthority {

	@Id
	private String nomeRole;

	@ManyToMany
	private List<User> users;

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

}
