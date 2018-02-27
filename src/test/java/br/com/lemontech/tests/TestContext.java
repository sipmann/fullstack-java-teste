package br.com.lemontech.tests;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lemontech.controller.ViagemController;
import br.com.lemontech.services.ViagemService;
 
@Configuration
public class TestContext {
 
    /*@Bean
    public ViagemController todoService() {
        return Mockito.mock(ViagemController.class);
    }*/
	
	@Bean
	public ViagemService viagemService() {
		return Mockito.mock(ViagemService.class);
	}
}