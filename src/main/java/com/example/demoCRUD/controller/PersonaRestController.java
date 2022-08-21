package com.example.demoCRUD.controller;

import com.example.demoCRUD.Service.API.PersonaServiceAPI;
import com.example.demoCRUD.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class PersonaRestController {
    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Persona> getAll(){
       return  personaServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Persona findPerson(@PathVariable Long id){
        return personaServiceAPI.get(id);
    }

    @CrossOrigin
    @PostMapping(value ="/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona obj = personaServiceAPI.save(persona);

        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id){
        Persona persona = personaServiceAPI.get(id);
        if(persona != null) {//si encuentra la perosna la borra returna code 200
            personaServiceAPI.delete(id);
        }else{//sino enceuntra la persona manda code 500
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
}
