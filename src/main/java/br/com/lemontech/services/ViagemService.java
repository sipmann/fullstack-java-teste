package br.com.lemontech.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lemontech.factory.ViagemFactory;
import br.com.lemontech.model.*;
import br.com.lemontech.selfbooking.wsselfbooking.beans.Solicitacao;
import br.com.lemontech.selfbooking.wsselfbooking.beans.aereo.Aereo;
import br.com.lemontech.selfbooking.wsselfbooking.beans.aereo.AereoSeguimento;
import br.com.lemontech.selfbooking.wsselfbooking.services.WsSelfBooking;
import br.com.lemontech.selfbooking.wsselfbooking.services.WsSelfBookingService;
import br.com.lemontech.selfbooking.wsselfbooking.services.request.PesquisarSolicitacaoRequest;
import br.com.lemontech.selfbooking.wsselfbooking.services.response.PesquisarSolicitacaoResponse;
import br.com.lemontech.utils.SysOpts;

/**
 * Consumidor do WS e responsável por encaminhar os dados para o banco
 * @author sipmann
 *
 */
@Component
public class ViagemService {
	
	@Autowired
	PersistService persist;
	
	@Autowired
	ViagemFactory viagem;
	
	@Autowired
	DateService dateService;
	
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
		req.setDataInicial(dateService.getGregorianFromMilis(c.getTimeInMillis()));
		req.setDataFinal(dateService.getGregorianFromMilis(d.getTime()));
		req.setRegistroInicial(1);

		WsSelfBooking port = new WsSelfBookingService().getWsSelfBookingPort();
		//TODO configuration from somewhere else
		
		PesquisarSolicitacaoResponse resp = port.pesquisarSolicitacao(SysOpts.env("applicationkeyClient", "base_teste_qa"),
				SysOpts.env("applicationUser", "f13aa9347eeedb0e4e80772a56af21a5"),
				SysOpts.env("applicationPassword","5ad47c2a43da64c5d7a42ee6b03dae36"), req);

		List<Viagem> lst = gerarViagensAPartirDe(resp.getSolicitacao());;
		
		persist.hi();
		persist.armazena(lst);
		
		return lst;
	}

	/**
	 * Parseia os dados para uma list de viagens. 
	 * @param sols
	 * @return
	 * @throws Exception
	 */
	private List<Viagem> gerarViagensAPartirDe(List<Solicitacao> sols) throws Exception {
		List<Viagem> lst = new ArrayList<>();
		
		for (Solicitacao sol: sols) {
			try {
				Aereo aereo = retornCiaAerea(sol);
				AereoSeguimento seg = retornSegmentoViagem(aereo);
				
				viagem.Id(sol.getIdSolicitacao())
				.Nome(sol.getSolicitante().getNome())
				.Ciaaerea(aereo.getSource())
				.Dhsaida(dateService.getDateFromGregorian(seg.getDataSaida()))
				.Dhchegada(dateService.getDateFromGregorian(seg.getDataChegada()))
				.Cidadeorigem(seg.getCidadeOrigem())
				.Cidadedestino(seg.getCidadeDestino());
				
				lst.add(viagem.build());
			} catch(Exception ex) {
				//TODO log system
			}
		}
		
		return lst;
	}

	private Aereo retornCiaAerea(Solicitacao sol) throws Exception {
		if (sol.getAereos() != null && sol.getAereos().getAereo().size() > 0)
			return sol.getAereos().getAereo().get(0);
		else
			throw new Exception("Solicitação " + sol.getIdSolicitacao() + " sem aereos");
	}
	
	private AereoSeguimento retornSegmentoViagem(Aereo aereo) throws Exception {
		if (aereo.getAereoSeguimento().size() > 0)
			return aereo.getAereoSeguimento().get(0);
		else
			throw new Exception("Aero " + aereo.getId() + " sem aereosSegmentos");
	}
}
