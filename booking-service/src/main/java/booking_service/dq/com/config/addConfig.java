package booking_service.dq.com.config;

//import booking_service.dq.com.entity.Blog;
//import booking_service.dq.com.repository.BlogRepository;
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.metamodel.Metamodel;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
//import java.util.Map;


@Configuration
public class addConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("booking_service.dq.com.entity") // Adjust to match your entities' package
                .persistenceUnit("default")
                .build();
    }
}
