package br.com.lemontech.controller;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lemontech.config.Constants;
import br.com.lemontech.dao.ViagemDAO;
import br.com.lemontech.model.Viagem;

@EnableRabbit
@Component
public class RabbitConsumer {

	@Autowired
	private ViagemDAO dao;

	/**
	 * Metodo responsavel por consumir o a mensagem do servico do rabbit Recebe um
	 * map para futuras implementacoes que venham a ser necessarias
	 * 
	 * @param messageObj
	 */
	@RabbitListener(queues = Constants.VIAGEM_LISTA)
	public void processaMensagem(Map<String, Object> messageObj) {
		try {
			System.out.println("Passag: " + ((Viagem) messageObj.get("viagem")).getNome());
			dao.gravar((Viagem) messageObj.get("viagem"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
