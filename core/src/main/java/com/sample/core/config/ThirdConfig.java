package com.sample.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author : JB
 * @packageName : com.sample.postgresql.config
 * @fileName : SecondConfig
 * @description :
 * @since : 2023-10-18
 */

@Configuration
@EnableJpaRepositories(
        basePackages = "com.sample.core.postgres",
        entityManagerFactoryRef = "thirdEntityManager",
        transactionManagerRef = "thirdTransactionManager"
)
public class ThirdConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.third-datasource")
    public DataSource thirdDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean thirdEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(thirdDataSource());
        em.setPackagesToScan(new String[] {"com.sample.core.postgres"});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> prop = new HashMap<>();
//        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.put("hibernate.hbm2ddl.auto", "create");
        em.setJpaPropertyMap(prop);

        return em;
    }

    @Bean
    public PlatformTransactionManager thirdTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(thirdEntityManager().getObject());
        return transactionManager;
    }
}
