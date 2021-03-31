package br.com.desafio.find.Desafio.service;

import br.com.desafio.find.Desafio.model.People;
import br.com.desafio.find.Desafio.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> getPeople() {
        return peopleRepository.findAll();
    }

    public void addNewPeople(People people) {
        if(people.getNumero() > 100 || people.getNumero() < 0){
            throw new IllegalStateException("Number out of the index of 0 - 100.");
        }
        peopleRepository.save(people);
    }

    public void deletePeople(Long peopleId) {
        if(!peopleRepository.existsById(peopleId)){
            throw new IllegalStateException("Id doesnt match any people");
        }
        peopleRepository.deleteById(peopleId);
    }



    public List<People> getPeople(LocalDate date) {
        return peopleRepository.findByData(date);
    }

    public List<People> getPeople(String email) {
        return peopleRepository.findByEmail(email);
    }

    public List<People> getPeople(int numero) {
        return peopleRepository.findByNumero(numero);
    }

    public List<People> getPeopleResultado(String resultado) {
        return peopleRepository.findByResultado(resultado);
    }

    //public Optional<People> getPeopleByDate(LocalDate date) {
    //    return peopleRepository.SearchBy(date);
    //}

    //public List<People> getPeopleById(Long id) {
    //    return peopleRepository.SearchBy(id);
    //}

    //public List<People> getPeopleByNumero(int numero) {
    //    return peopleRepository.SearchBy(numero);
    //}

    //public List<People> getPeopleByResultado(String resultado) {
    //    return peopleRepository.SearchBy(resultado);
    //}
}
