package br.com.trabalho.controller;

import br.com.trabalho.banco.Estoque;
import br.com.trabalho.banco.Usuario;
import br.com.trabalho.repository.EstoqueRepository;
import br.com.trabalho.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @ResponseBody
    @PostMapping(value = "/grava/{solicitante}")
    public String insere(@RequestBody Estoque estoque, @PathVariable("solicitante") Long solicitante){

        //valida se o solicitante tem permissao p/ cadastrar a loja
        int permissao = solicitanteTemPermissao(solicitante);
        if(permissao == -1)
            return "Solicitante nao encontrado";
        if (permissao == 0)
            return "Solicitante sem permissao";

        try{
            repository.save(estoque);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na gravação: " + e.getMessage();
        }
    }

    @ResponseBody
    @PostMapping(value = "/remove/{id}/{solicitante}")
    public String remove(@PathVariable("id") Long id, @PathVariable("solicitante") Long solicitante){

        //valida se o solicitante tem permissao p/ cadastrar a loja
        int permissao = solicitanteTemPermissao(solicitante);
        if(permissao == -1)
            return "Solicitante nao encontrado";
        if (permissao == 0)
            return "Solicitante sem permissao";

        try{
            repository.deleteById(id);
            return "Sucesso!";
        } catch (Exception e){
            return "Erro na exclusão: " + e.getMessage();
        }
    }

    @ResponseBody
    @GetMapping(value = "/busca-todos")
    public List<Estoque> buscaTodos(){
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/busca/{id}")
    public Optional<Estoque> buscaPorId(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    private int solicitanteTemPermissao(Long solicitante){
        Optional<Usuario> usuario = usuarioRepository.findById(solicitante);
        if(!usuario.isPresent()){
            return -1;
        }
        Usuario user = usuario.get();
        // cadastrar o cargo 2 como Gerente
        if(user.getCargo_id() != 2){
            return 0;
        }
        return 1;
    }
}
