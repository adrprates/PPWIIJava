package com.pwii.stock_management.service.impl;

import com.pwii.stock_management.model.Cliente;
import com.pwii.stock_management.model.Fornecedor;
import com.pwii.stock_management.repository.ClienteRepository;
import com.pwii.stock_management.repository.FornecedorRepository;
import com.pwii.stock_management.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> getAllFornecedores () {
        return fornecedorRepository.findAll();
    }

    @Override
    public void salvarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    @Override
    public Fornecedor getFornecedorById(Long id) {
        Optional<Fornecedor> optional = fornecedorRepository.findById(id);
        Fornecedor fornecedor = null;
        if(optional.isPresent()){
            fornecedor = optional.get();
        } else{
            throw new RuntimeException("Fornecedor não encontrado para o id " + id);
        }
        return fornecedor;
    }

    @Override
    public void deletarFornecedorById(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
