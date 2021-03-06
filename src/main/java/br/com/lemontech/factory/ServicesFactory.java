package br.com.lemontech.factory;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.lemontech.dao.PersistLocal;
import br.com.lemontech.dao.PersistRabbit;
import br.com.lemontech.services.PersistService;
import br.com.lemontech.utils.SysOpts;


@Component
public class ServicesFactory {

	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PersistService getPersistService() {
		//TODO check if rabbit on variable
		String rabbit = SysOpts.env("RABBITHOST", "");
		System.out.println("Rabbit host:: " + rabbit);
		if (rabbit.equals(""))
			return new PersistLocal();
		else
			return new PersistRabbit();
	}
	
}
