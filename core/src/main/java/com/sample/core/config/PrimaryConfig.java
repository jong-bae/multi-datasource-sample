package com.sample.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author : JB
 * @packageName : com.sample.mssql.config
 * @fileName : PrimaryConfig
 * @description :
 * @since : 2023-10-18
 */

@Configuration
@EnableJpaRepositories(
        basePackages = "com.sample.core.maria",
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDataSource());
        em.setPackagesToScan(new String[] {"com.sample.core.maria"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> prop = new HashMap<>();
        prop.put("hibernate.hbm2ddl.auto", "update");
        em.setJpaPropertyMap(prop);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager primaryTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(primaryEntityManager().getObject());
        return transactionManager;
    }
}
