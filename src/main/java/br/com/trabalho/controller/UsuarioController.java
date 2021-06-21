package br.com.trabalho.controller;

import br.com.trabalho.banco.Usuario;
import br.com.trabalho.repository.CargoRepository;
import br.com.trabalho.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    CargoRepository cargoRepository;

    @ResponseBody
    @PostMapping(value = "/grava")
    public String grava(@RequestBody Usuario usuario){

        if (!cargoRepository.findById(usuario.getCargo_id()).isPresent()){
            return "Cargo nao encontrado!";
        }

        try{
            repository.save(usuario);
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
    public List<Usuario> buscaTodos(){
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/busca/{id}")
    public Optional<Usuario> buscaPorId(@PathVariable("id") Long id){
        return repository.findById(id);
    }
}
