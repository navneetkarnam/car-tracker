package io.navneetkarnam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean emf2(){

        LocalContainerEntityManagerFactoryBean emf2 = new LocalContainerEntityManagerFactoryBean();
        emf2.setDataSource(getDataSource());
        emf2.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf2.setPackagesToScan("io.navneetkarnam.entity");


        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        emf2.setJpaProperties(properties);
        return emf2;
    }

    @Bean
    public DataSource getDataSource(){

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/tracker_readings?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf2){

        JpaTransactionManager txm = new JpaTransactionManager(emf2);
        return txm;
    }
}
