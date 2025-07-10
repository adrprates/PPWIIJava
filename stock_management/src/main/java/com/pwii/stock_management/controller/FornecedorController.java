package com.pwii.stock_management.controller;

import com.pwii.stock_management.model.Fornecedor;
import com.pwii.stock_management.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping({"","/"})
    public String verHomePage(Model model) {
        model.addAttribute("listFornecedores", fornecedorService.getAllFornecedores());
        return "fornecedor/index";
    }

    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor/criar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute @Valid Fornecedor fornecedor, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "fornecedor/criar";
        }
        fornecedorService.salvarFornecedor(fornecedor);
        return "redirect:/fornecedor";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Fornecedor fornecedor = fornecedorService.getFornecedorById(id);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute @Valid Fornecedor fornecedor, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "fornecedor/editar";
        }
        fornecedorService.salvarFornecedor(fornecedor);
        return "redirect:/fornecedor";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        fornecedorService.deletarFornecedorById(id);
        return "redirect:/fornecedor";
    }
}
