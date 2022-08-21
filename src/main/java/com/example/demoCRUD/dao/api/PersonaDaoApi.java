package com.example.demoCRUD.dao.api;
import com.example.demoCRUD.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDaoApi extends CrudRepository<Persona,Long> {


}
