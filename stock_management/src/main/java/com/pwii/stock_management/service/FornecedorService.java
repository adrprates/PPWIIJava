package com.pwii.stock_management.service;

import com.pwii.stock_management.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    List<Fornecedor> getAllFornecedores();
    void salvarFornecedor(Fornecedor fornecedor);
    Fornecedor getFornecedorById(Long id);
    void deletarFornecedorById(Long id);
}
