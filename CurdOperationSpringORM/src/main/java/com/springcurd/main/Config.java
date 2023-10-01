package com.springcurd.main;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.springcurd.dao.StudentDao;
import org.hibernate.SessionFactory;

@Configuration
@EnableTransactionManagement
public class Config 
{
    String dburl = "jdbc:mysql://localhost:3306/springjdbc";
    String dbusername = "root";
    String dbpassword = "bugsop";

			    @Bean
			    public DataSource getDataSource(){
			        DataSource dataSource = new DriverManagerDataSource(dburl, dbusername, dbpassword); // LocalSessionFactoryBean ke 3 parameter ke ander 1st parta meter hota hai DataSource ka object jo ham yaha se nikal rahe DriverManagerDataSource class ka use kar kyu DataSource interfce hai to uske child class ko use kar iska object bana DriverManagerDataSource ka hi constructor hai jisme 3 parameter jata hai...database ka usrl,username,password jo hamne uper me ek string me sstore kar ke yaha pass kar diya hai...
			        return dataSource;
			    }
			    private Properties gethibernateProperties(){
			        Properties properties = new Properties();   
			        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			        properties.put("hibernate.show_sql", "true"); 
			        properties.put("hibernate.hbm2ddl.auto", "update"); 
			        return properties;
			    }
			    private String getEntityPackageToScan(){
			        return "com.springcurd.entities";
			    }
    @Bean
    public LocalSessionFactoryBean getLocalSessionFactoryBean(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setHibernateProperties(gethibernateProperties());
        sessionFactory.setPackagesToScan(getEntityPackageToScan());
        return sessionFactory;
    }
   
    @Bean
    public SessionFactory getSessionFactory(){
    	SessionFactory sessionFactory = getLocalSessionFactoryBean().getObject(); 
    	return sessionFactory;
    }
    
    @Bean()
    public HibernateTemplate getHibernateTemplate(){
        HibernateTemplate template = new HibernateTemplate(getSessionFactory()); 
        return template;
    }
   
    
    @Bean()
    public StudentDao studentDaoRef() {
        StudentDao studentDao = new StudentDao();
        studentDao.setHibernateTemplate(getHibernateTemplate()); 
        return studentDao;
    }
    
 
 // DaoClass <- HibernateTempalte <- SessionFactory <- LocalSessionFactoryBean(DataSource,Properties,AnnotatedClass) <- DataSource <- DriverManagerDataSourece  
    
    
    @Bean
    public HibernateTransactionManager enableTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory());
        return transactionManager;
    }
    
}
