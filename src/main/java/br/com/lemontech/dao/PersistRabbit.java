/**
 * Extrair ainda mais a parte de channelService.basic... para que este service nao saiba exatamente com o que esta lidando.. 
 * ou renomear a classe para ficar claro q este é um service rabbit.
 */
package br.com.lemontech.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.lemontech.config.Constants;
import br.com.lemontech.model.Viagem;
import br.com.lemontech.services.PersistService;

/**
 * Service/Dao que envia os dados para um servidor rabbit para que só entao seja
 * feito a persistencia.
 * 
 * @author sipmann
 *
 */
public class PersistRabbit implements PersistService {

	/*
	 * @Autowired private Channel channelService;
	 */
	@Autowired
	AmqpTemplate template;

	/**
	 * Envia a persistencia de uma viagem para o rabbit
	 * 
	 * @param Viagem
	 * @return
	 */
	@Override
	public boolean armazena(Viagem viagem) {
		/*
		 * try { channelService.queueDeclare(Constants.VIAGEM_LISTA, false, false,
		 * false, null); // channelService.basicPublish("", VIAGEM_LISTA, null,
		 * viagem.getBytes()); channelService.basicPublish("", Constants.VIAGEM_LISTA,
		 * null, "oi".getBytes()); return true; } catch (IOException ex) { //
		 * ex.printStackTrace(); return false; }
		 */

		Map<String, Object> message = new HashMap<String, Object>();
		message.put("viagem", viagem);
		template.convertAndSend(Constants.VIAGEM_LISTA, message);
		return true;
	}

	/**
	 * Envia a persistencia de uma lista de viagens para o rabbit
	 * 
	 * @param List
	 *            de viagens
	 * @return
	 */
	@Override
	public boolean armazena(List<Viagem> viagem) {
		for (Viagem v : viagem) {
			if (!armazena(v))
				return false;
		}
		return true;
	}

	@Override
	public void hi() {
		System.out.println("Hello from PersistRabbit");
	}

}
