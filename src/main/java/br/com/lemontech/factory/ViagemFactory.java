package br.com.lemontech.factory;

import java.sql.Date;

import org.springframework.stereotype.Component;

import br.com.lemontech.model.Viagem;

@Component
public class ViagemFactory {

	private int id;
	private String nome;
	private String ciaaerea;
	private Date dhsaida;
	private Date dhchegada;
	private String cidadeorigem;
	private String cidadedestino;

	private ViagemFactory() {
	}

	public static ViagemFactory builder() {
		return new ViagemFactory();
	}

	public ViagemFactory Id(int id) {
		this.id = id;
		return this;
	}

	public ViagemFactory Nome(String nome) {
		this.nome = nome;
		return this;
	}

	public ViagemFactory Ciaaerea(String ciaaerea) {
		this.ciaaerea = ciaaerea;
		return this;
	}

	public ViagemFactory Dhsaida(Date dhsaida) {
		this.dhsaida = dhsaida;
		return this;
	}

	public ViagemFactory Dhchegada(Date dhchegada) {
		this.dhchegada = dhchegada;
		return this;
	}

	public ViagemFactory Cidadeorigem(String cidadeorigem) {
		this.cidadeorigem = cidadeorigem;
		return this;
	}

	public ViagemFactory Cidadedestino(String cidadedestino) {
		this.cidadedestino = cidadedestino;
		return this;
	}

	public Viagem build() {
		return new Viagem(this.id, this.nome, this.ciaaerea, this.dhsaida, this.dhchegada, this.cidadeorigem,
				this.cidadedestino);
	}
}
