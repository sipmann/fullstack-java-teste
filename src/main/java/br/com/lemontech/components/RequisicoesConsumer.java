package br.com.lemontech.components;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lemontech.model.*;
import br.com.lemontech.selfbooking.wsselfbooking.beans.Solicitacao;
import br.com.lemontech.selfbooking.wsselfbooking.beans.aereo.Aereo;
import br.com.lemontech.selfbooking.wsselfbooking.beans.aereo.AereoSeguimento;
import br.com.lemontech.selfbooking.wsselfbooking.services.WsSelfBooking;
import br.com.lemontech.selfbooking.wsselfbooking.services.WsSelfBookingService;
import br.com.lemontech.selfbooking.wsselfbooking.services.request.PesquisarSolicitacaoRequest;
import br.com.lemontech.selfbooking.wsselfbooking.services.response.PesquisarSolicitacaoResponse;

/**
 * Consumidor do WS e responsável por encaminhar os dados para o banco
 * @author sipmann
 *
 */
@Component
public class RequisicoesConsumer {
	
	@Autowired
	PersistService persist;
	
	/**
	 * Retorna um list das viagens vindas do WS. Encaminha os dados para armazenamento
	 * @param mesesRetroativo int de quantos meses retroativo pegar os dados.
	 * @return List of Viagem
	 * @throws Exception
	 */
	public List<Viagem> getViagens(int mesesRetroativo) throws Exception {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MONTH, mesesRetroativo * -1);

		PesquisarSolicitacaoRequest req = new PesquisarSolicitacaoRequest();
		req.setDataInicial(getGregorianFromMilis(c.getTimeInMillis()));
		req.setDataFinal(getGregorianFromMilis(d.getTime()));
		req.setRegistroInicial(1);

		WsSelfBooking port = new WsSelfBookingService().getWsSelfBookingPort();
		//TODO configuration from somewhere else
		PesquisarSolicitacaoResponse resp = port.pesquisarSolicitacao("base_teste_qa",
				"f13aa9347eeedb0e4e80772a56af21a5", "5ad47c2a43da64c5d7a42ee6b03dae36", req);

		List<Viagem> lst = parseSolicitacao(resp.getSolicitacao());;
		
		persist.armazena(lst);
		
		return lst;
	}

	/**
	 * Parseia os dados para uma list de viagens. 
	 * @param sols
	 * @return
	 * @throws Exception
	 */
	private List<Viagem> parseSolicitacao(List<Solicitacao> sols) throws Exception {
		List<Viagem> lst = new ArrayList<>();
		
		for (Solicitacao sol: sols) {
			try {
				Aereo aereo = retornAero(sol);
				AereoSeguimento seg = retornAeroSeg(aereo);
				
				lst.add(new Viagem(sol.getIdSolicitacao(), 
						sol.getSolicitante().getNome(),
						aereo.getSource(),
						getDateFromGregorian(seg.getDataSaida()),
						getDateFromGregorian(seg.getDataChegada()),
						seg.getCidadeOrigem(),
						seg.getCidadeDestino()
						));
			} catch(Exception ex) {
				//TODO log system
			}
		}
		
		return lst;
	}

	private Aereo retornAero(Solicitacao sol) throws Exception {
		if (sol.getAereos() != null && sol.getAereos().getAereo().size() > 0)
			return sol.getAereos().getAereo().get(0);
		else
			throw new Exception("Solicitação " + sol.getIdSolicitacao() + " sem aereos");
	}
	
	private AereoSeguimento retornAeroSeg(Aereo aereo) throws Exception {
		if (aereo.getAereoSeguimento().size() > 0)
			return aereo.getAereoSeguimento().get(0);
		else
			throw new Exception("Aero " + aereo.getId() + " sem aereosSegmentos");
	}

	/**
	 * Utilitário de transformação de valores/data
	 * @param millisecond Eg: new Date().getTime();
	 * @return
	 */
	private XMLGregorianCalendar getGregorianFromMilis(Long millisecond) {
		try {
			GregorianCalendar dt = new GregorianCalendar();
			dt.setTimeInMillis(millisecond);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(dt);
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Utilitário de transformação de valores/data
	 * @param greg
	 * @return
	 */
	private java.sql.Date getDateFromGregorian(XMLGregorianCalendar greg) {
		java.sql.Date d = new java.sql.Date(greg.getMillisecond());
		return d;
	}
}
