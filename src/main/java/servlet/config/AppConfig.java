package servlet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author kirillparolys
 * @version 1.1
 * @since 2018-03-28
 */

@Configuration
@PropertySource("/app.properties")
@ComponentScan(basePackages = "servlet")
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    /**
     * @see Autowired
     */
    @Autowired
    private Environment environment;

    /**
     * @return instance of JpaTransactionManager
     *
     * @see JpaTransactionManager
     * @see javax.persistence.EntityManagerFactory
     *
     * @see Bean
     */
    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    /**
     * @return  instance LocalContainerEntityManagerFactoryBean
     *
     * @see LocalContainerEntityManagerFactoryBean
     * @see HibernateJpaVendorAdapter
     *
     * @see Bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("servlet.model");
        bean.setPersistenceUnitName("servlet-unit");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.setJpaProperties(jpaProperties());
        return bean;
    }

    /**
     * @return instance of Properties with set of properties from app.properties
     *
     * @see Environment
     */
    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("h2.hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("h2.hibernate.show_sql"));
        properties.setProperty("hibernate.dialect", environment.getProperty("h2.hibernate.dialect"));
        return properties;
    }

    /**
     * @return instance of DataSource with set class name from app.properties
     *
     * @see DriverManagerDataSource
     */
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("h2.db.Driver"));
        dataSource.setUrl(environment.getProperty("h2.db.url"));
        return dataSource;
    }
}
