package br.com.lemontech.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String ciaaerea;
	private Date dhsaida;
	private Date dhchegada;
	private String cidadeorigem;
	private String cidadedestino;
	
	public Viagem() {
		
	}
	
	public Viagem(int id, String nome, String ciaaerea, Date dhsaida, Date dhchegada, String cidadeorigem,
			String cidadedestino) {
		super();
		this.id = id;
		this.nome = nome;
		this.ciaaerea = ciaaerea;
		this.dhsaida = dhsaida;
		this.dhchegada = dhchegada;
		this.cidadeorigem = cidadeorigem;
		this.cidadedestino = cidadedestino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCiaaerea() {
		return ciaaerea;
	}

	public void setCiaaerea(String ciaaerea) {
		this.ciaaerea = ciaaerea;
	}

	public Date getDhsaida() {
		return dhsaida;
	}

	public void setDhsaida(Date dhsaida) {
		this.dhsaida = dhsaida;
	}

	public Date getDhchegada() {
		return dhchegada;
	}

	public void setDhchegada(Date dhchegada) {
		this.dhchegada = dhchegada;
	}

	public String getCidadeorigem() {
		return cidadeorigem;
	}

	public void setCidadeorigem(String cidadeorigem) {
		this.cidadeorigem = cidadeorigem;
	}

	public String getCidadedestino() {
		return cidadedestino;
	}

	public void setCidadedestino(String cidadedestino) {
		this.cidadedestino = cidadedestino;
	}

}
