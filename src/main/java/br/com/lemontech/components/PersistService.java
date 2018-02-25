package br.com.lemontech.components;

import java.util.List;

import br.com.lemontech.model.Viagem;

public interface PersistService {
	public boolean armazena(Viagem viagem);
	public boolean armazena(List<Viagem> viagens);
	public void hi();
}
