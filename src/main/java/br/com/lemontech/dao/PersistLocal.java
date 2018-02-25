package br.com.lemontech.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lemontech.components.PersistService;
import br.com.lemontech.model.Viagem;

/**
 * Controller que realiza a persistencia em banco de dados do que for recebido. 
 * Pode ser transformado futuramente em uma aplicação a parte para ser chamada 
 * remotamente, podendo ser a partir de request diretamente na camada ou invocação
 * remotada de serviço do próprio Spring.
 * @author sipmann
 *
 */

public class PersistLocal implements PersistService {
	
	@Autowired
	private ViagemDAO dao;
	
	/**
	 * Persistencia de uma viagem
	 * @param Viagem
	 * @return
	 */
	@Override
	public boolean armazena(Viagem viagem) {
		//TODO check for failed persist
		//TODO check if actual viagem already exists in the DB
		dao.gravar(viagem);
		return true;
	}
	
	/**
	 * Persistencia de uma listagem de viagens
	 * @param List de viagens
	 * @return
	 */
	@Override
	public boolean armazena(List<Viagem> viagem) {
		//TODO check for failed persist
		//TODO check if actual viagem already exists in the DB
		dao.gravar(viagem);
		return true;
	}

	@Override
	public void hi() {
		System.out.println("Hello from localpersist");
	}
	
}
