package br.com.desafio.find.Desafio;

import br.com.desafio.find.Desafio.repository.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.desafio.find.Desafio.model.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebMvc
public class PeopleConfig {

    @Bean
    CommandLineRunner commandLineRunner(PeopleRepository repository){
        return args -> {
            People julio = new People(1L,"julio@gmail.com",15);
            julio.setData(julio.getData());
            julio.setResultado(julio.getResultado());
            People joao = new People(2L,"joao@gmail.com",30);
            joao.setData(joao.getData());
            joao.setResultado(joao.getResultado());
            repository.saveAll(List.of(julio,joao));
        };
    }


}
