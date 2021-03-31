package br.com.desafio.find.Desafio.controller;

import br.com.desafio.find.Desafio.model.People;
import br.com.desafio.find.Desafio.service.PeopleService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService PeopleService) {
        this.peopleService = PeopleService;
    }

    @GetMapping
    public List<People> getPeople(){
        return peopleService.getPeople();
    }

    @GetMapping("/data/{date}")
    public List<People> getPeopleDate(@PathVariable String date){
        return peopleService.getPeople(LocalDate.parse(date));
    }

    @GetMapping("/email/{email}")
    public List<People> getPeople(@PathVariable String email){
        return peopleService.getPeople(email);
    }

    @GetMapping("/numero/{numero}")
    public List<People> getPeople(@PathVariable int numero){
        return peopleService.getPeople(numero);
    }

    @GetMapping("/resultado/{resultado}")
    public ResponseEntity<List<People>> getPeopleResultado(@PathVariable String resultado){
        return ResponseEntity.ok(peopleService.getPeopleResultado(resultado));
    }

    @PostMapping
    public void registerNewUser(@RequestBody People people){
        peopleService.addNewPeople(people);
    }

    @DeleteMapping(path = "{peopleId}")
    public void deleteStudent(@PathVariable("peopleId") Long peopleId){
        peopleService.deletePeople(peopleId);
    }
}
