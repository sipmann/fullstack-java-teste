// mvn -Dtest=BasicTests test
/**
 * Melhorias, configuração de banco para testes, não usar o oficial obviamente
 * Validação do model que é exibido na view
 */

package br.com.lemontech.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.lemontech.config.AppWebConfiguration;
import br.com.lemontech.config.JPAConfiguration;
import br.com.lemontech.controller.ViagemController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, AppWebConfiguration.class, JPAConfiguration.class})
@WebAppConfiguration
public class BasicTests {
	@Autowired
	private WebApplicationContext context;
    
	private MockMvc mockMvc;
    
    @Autowired
    private ViagemController viagemController;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(viagemController)
                .setViewResolvers(viewResolver())
                .build();
    }

    @Test
    public void testSimplesGET() throws Exception {
        mockMvc.perform(get("/viagens"))
                .andExpect(status().isOk())
                .andExpect(view().name("viagens/listagem"))
                .andExpect(forwardedUrl("/WEB-INF/views/viagens/listagem.jsp"));
    }
    
    @Test
    public void testSimplesGETFromDb() throws Exception {
        mockMvc.perform(get("/viagens/fromdb"))
                .andExpect(status().isOk())
                .andExpect(view().name("viagens/listagem"))
                .andExpect(forwardedUrl("/WEB-INF/views/viagens/listagem.jsp"));
    }
    
    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
