package tech.wetech.example;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.wetech.example.hibernate.HibernateUtils;

import javax.persistence.EntityManagerFactory;

/**
 * @author cjbi
 */
@SpringBootApplication
public class QPaaSExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(QPaaSExampleApplication.class, args);
    }

    @Bean
    public HibernateUtils hibernateUtils(EntityManagerFactory entityManagerFactory) {
        return new HibernateUtils(entityManagerFactory.unwrap(SessionFactory.class));
    }

}
