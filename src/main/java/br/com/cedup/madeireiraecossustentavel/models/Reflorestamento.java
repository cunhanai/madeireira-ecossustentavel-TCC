package br.com.cedup.madeireiraecossustentavel.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reflorestamento implements Serializable {

	// ATRIBUTOS

	/**
	 * Default Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID/Codigo da madeira.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Tipo de madeira.
	 */
	private String tipo;

	/**
	 * Quantidade de metros cublicos de madeira cortada.
	 */
	private double qtdeMCubicos;

	/**
	 * Data e hora do registro.
	 */
	private LocalDateTime dataHora;

	/**
	 * Usuario responsavel pelo registro.
	 */
	@ManyToOne
	private User userResp;

	// GETTERS AND SETTERS

	/**
	 * @return o ID/Codigo da madeira em <code>long</code>.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id o ID/Codigo da madeira para ser settado em <code>long</code>.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return o tipo tipo de madeira em <code>String</code>.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo o tipo de madeira para ser settado em <code>String</code>.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return a quantidade de metros cublicos de madeira cortada em
	 *         <code>double</code>.
	 */
	public double getQtdeMCubicos() {
		return qtdeMCubicos;
	}

	/**
	 * @param qtdeMCubicos the a quantidade de metros cublicos de madeira cortada
	 *                     para ser settada em <code>double</code>.
	 */
	public void setQtdeMCubicos(double qtdeMCubicos) {
		this.qtdeMCubicos = qtdeMCubicos;
	}

	/**
	 * @return a data e hora do registro em <code>LocalDateTime</code>.
	 */
	public LocalDateTime getDataHora() {
		return dataHora;
	}

	/**
	 * @param dataHora a data e hora do registro para serem settados em
	 *                 <code>LocalDateTime</code>.
	 */
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	/**
	 * @return the default serialversionuid.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return o usuario responsavel pelo registro em <code>User</code>.
	 */
	public User getUserResp() {
		return userResp;
	}

	/**
	 * @param userResp o usuario responsavel pelo registro para ser settado em
	 *                 <code>User</code>.
	 */
	public void setUserResp(User userResp) {
		this.userResp = userResp;
	}

}
