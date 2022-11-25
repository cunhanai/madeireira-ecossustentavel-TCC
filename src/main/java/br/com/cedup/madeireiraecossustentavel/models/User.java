package br.com.cedup.madeireiraecossustentavel.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private String login;

	private String nomeCompleto;

	private String senha;

	@OneToMany
	private List<Madeira> registrosMade;

	@OneToMany
	private List<Reflorestamento> registroReflo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "login"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;

	// GETTERS AND SETTERS

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// OVERRIDE METHODS

	public List<Madeira> getRegistrosMade() {
		return registrosMade;
	}

	public void setRegistrosMade(List<Madeira> registrosMade) {
		this.registrosMade = registrosMade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<Reflorestamento> getRegistroReflo() {
		return registroReflo;
	}

	public void setRegistroReflo(List<Reflorestamento> registroReflo) {
		this.registroReflo = registroReflo;
	}

}
