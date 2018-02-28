package br.com.lemontech.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.lemontech.utils.SysOpts;

@EnableTransactionManagement
public class JPAConfiguration {

	/**
	 * Configuração do EntityManagerFactory com a configuração de conexão 
	 * com o banco de dados.
	 * 
	 * 
	 * @future
	 * Implementação de um serviço de "ServiceDiscovery" como consul para carregar
	 * as configurações de conexão.
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		factory.setJpaVendorAdapter(vendorAdapter);
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername(SysOpts.env("appMysqlUser", "root"));
		ds.setPassword(SysOpts.env("appMysqlPass", "senha-mysql"));
		ds.setUrl("jdbc:mysql://"+SysOpts.env("appMysqlHost", "159.65.235.185:3306")+SysOpts.env("appMysqlDB", "/viagens"));
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		factory.setDataSource(ds);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update"); //gera as tabelas
		factory.setJpaProperties(props);
		
		factory.setPackagesToScan("br.com.lemontech.model");
		
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory em) {
		return new JpaTransactionManager(em);
	}
}
