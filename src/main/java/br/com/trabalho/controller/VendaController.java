package br.com.trabalho.controller;

import br.com.trabalho.banco.Estoque;
import br.com.trabalho.banco.Venda;
import br.com.trabalho.banco.VendaItem;
import br.com.trabalho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @Autowired
    VendaItemRepository vendaItemRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    LojaRepository lojaRepository;

    @ResponseBody
    @PostMapping(value = "/grava")
    public String insere(Venda venda, List<VendaItem> listaItens){

        //valida dados da venda
        if(!lojaRepository.findById(venda.getLoja_id()).isPresent())
            return "Loja nao encontrada";
        if(!usuarioRepository.findById(venda.getUsuario_id()).isPresent())
            return "Usuario nao encontrado";

        //valida qtde itens da venda
        List<Estoque> listaEstoque = estoqueRepository.findByLoja_id(venda.getLoja_id());
        for(VendaItem item : listaItens){
            boolean existe = false;
            //verifica se todos itens estao no estoque
            for (Estoque estoque: listaEstoque){
                if (estoque.getProduto_id().equals(item.getProduto_id())) {
                    existe = true;
                    break;
                }
                if(estoque.getProduto_id().equals(item.getProduto_id()) &&
                        estoque.getQuantidade() < item.getQuantidade())
                    return "Produto com codigo " + item.getProduto_id() + " com quantidade insuficiente no estoque";
            }
            if(!existe)
                return "Produto com codigo " + item.getProduto_id() + " nao esta presente no estoque";
        }

        try{
            repository.save(venda);
            for(VendaItem item : listaItens){
                item.setVenda_id(venda.getId());
                vendaItemRepository.save(item);
            }
            return "Sucesso";
        } catch (Exception e){
            return "Erro na gravação: " + e.getMessage();
        }
    }
}
