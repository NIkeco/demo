package mx.com.bimbo.data.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "lealtadEntityManagerFactory",
	basePackages = "mx.com.bimbo.data.persistence.dao",
	transactionManagerRef= "lealtadTransactionManager")
@ComponentScan(basePackages= {"mx.com.bimbo.data.persistence.dao", "mx.com.bimbo.data.persistence.service"})
public class lealtadDataStore {

	@Value ("${lealtad.jpa.database-platform}")
	private String dialect;
			
	@Bean(name = "lealtadDataSource")
	@ConfigurationProperties(prefix = "lealtad.datasource")
	public DataSource datasource () {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name= "lealtadEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean (@Qualifier("lealtadDataSource") DataSource datasourse) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(datasourse);
		factoryBean.setPackagesToScan("mx.com.bimbo.data.persistence.model");
		
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendor);
		Map<String, Object> properties = new HashMap<>();
		
		properties.put("hibernate.dialect", dialect);
		factoryBean.setJpaPropertyMap(properties);
	
		
		return factoryBean;		
	} 
	
	
	@Bean (name = "lealtadTransactionManager")
	public PlatformTransactionManager platformTransactionManager (
			@Qualifier("lealtadEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
