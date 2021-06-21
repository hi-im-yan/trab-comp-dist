package br.com.trabalho.controller;

import br.com.trabalho.banco.Loja;
import br.com.trabalho.banco.Usuario;
import br.com.trabalho.repository.LojaRepository;
import br.com.trabalho.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    LojaRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @ResponseBody
    @PostMapping(value = "/grava/{solicitante}")
    public String grava(@RequestBody Loja loja, @PathVariable("solicitante") Long solicitante){

        //valida se o solicitante tem permissao p/ cadastrar a loja
        int permissao = solicitanteTemPermissao(solicitante);
        if(permissao == -1)
            return "Solicitante nao encontrado";
        if (permissao == 0)
            return "Solicitante sem permissao";

        //valida se o gerente informado possui o cargo correto
        Optional<Usuario> gerente = usuarioRepository.findById(loja.getGerente_id());
        if(!gerente.isPresent()){
            return "Gerente nao encontrado";
        }
        Usuario userGerente = gerente.get();
        // cadastrar o cargo 2 como Gerente
        if(userGerente.getCargo_id() != 2){
            return "Gerente informado no cadastro nao cadastrado com o cargo correto";
        }

        try{
            repository.save(loja);
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
    public List<Loja> buscaTodos(){
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/busca/{id}")
    public Optional<Loja> buscaPorId(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    private int solicitanteTemPermissao(Long solicitante){
        Optional<Usuario> usuario = usuarioRepository.findById(solicitante);
        if(!usuario.isPresent()){
            return -1;
        }
        Usuario user = usuario.get();
        // cadastrar o cargo 1 como Administrador
        if(user.getCargo_id() != 1){
            return 0;
        }
        return 1;
    }
}
