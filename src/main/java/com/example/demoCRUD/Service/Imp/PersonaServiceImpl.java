package com.example.demoCRUD.Service.Imp;

import com.example.demoCRUD.commons.GenerecServiceImp;
import com.example.demoCRUD.dao.api.PersonaDaoApi;
import com.example.demoCRUD.model.Persona;
import com.example.demoCRUD.Service.API.PersonaServiceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenerecServiceImp<Persona,Long> implements PersonaServiceAPI {
    @Autowired
    private PersonaDaoApi personaDaoApi;
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaDaoApi;
    }


}
