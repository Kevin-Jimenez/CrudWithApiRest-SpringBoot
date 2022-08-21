package com.example.demoCRUD.controller;

import com.example.demoCRUD.Service.API.PersonaServiceAPI;
import com.example.demoCRUD.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonaController {
    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    //Listar
    @CrossOrigin()
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", personaServiceAPI.getAll());
        return "index";
    }
    //APiVue
    
    @GetMapping("/all")
    public List<Persona> getAll(){
        return personaServiceAPI.getAll();
    }

    //Actualizar
    @GetMapping("/save/{id}")
    public  String showSave(@PathVariable("id") Long id, Model model){
        if(id != null && id != 0){
            model.addAttribute("persona",personaServiceAPI.get(id));
        }else{
            model.addAttribute("persona", new Persona());
        }
        return "save";
    }

    //Guardar
    @PostMapping("/save")
    public String save(Persona persona, Model model){
        personaServiceAPI.save(persona);
        return "redirect:/";  //-> direcciona a la vista index
    }

    //eliminar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        personaServiceAPI.delete(id);
        return "redirect:/";
    }
}
