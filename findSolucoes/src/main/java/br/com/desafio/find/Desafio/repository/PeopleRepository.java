package br.com.desafio.find.Desafio.repository;

import br.com.desafio.find.Desafio.model.People;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {

    List<People> findByData (LocalDate date);

    List<People> findByEmail(String email);

    List<People> findByNumero(int numero);

    List<People> findByResultado(String resultado);

}
