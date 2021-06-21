package br.com.trabalho.controller;

import br.com.trabalho.banco.Cargo;
import br.com.trabalho.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoRepository repository;

    @ResponseBody
    @PostMapping(value = "/grava")
    public String insere(@RequestBody Cargo cargo){

        if (repository.findByNome(cargo.getNome()) != null){
            return "Cargo já existente!";
        }

        try{
            repository.save(cargo);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na gravação: " + e.getMessage();
        }
    }

    @ResponseBody
    @PostMapping(value = "/remove/{id}")
    public String remove(@PathVariable("id") Long id){
        try{
            repository.deleteById(id);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na exclusão: " + e.getMessage();
        }
    }

    @ResponseBody
    @GetMapping(value = "/busca-todos")
    public List<Cargo> buscaTodos(){
        return repository.findAll();
    }
}
