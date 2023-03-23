package com.desafio.backend.controller;

import com.desafio.backend.model.Company;
import com.desafio.backend.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> list() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable String id) {
        return companyRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/total")
    public Long getCount(){
        return companyRepository.count();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable String id, @RequestBody Company company) {
        return companyRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNomeFantasia(company.getNomeFantasia());
                    recordFound.setCnpj(company.getCnpj());
                    recordFound.setCep(company.getCep());
                    recordFound.setUf(company.getUf());
                    recordFound.setCidade(company.getCidade());
                    recordFound.setBairro(company.getBairro());
                    recordFound.setLogradouro(company.getLogradouro());
                    recordFound.setNumero(company.getNumero());
                    recordFound.setComplemento(company.getComplemento());

                    Company updated = companyRepository.save(recordFound);

                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        companyRepository.findById(id)
                .map(recordFound -> {
                    companyRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
        return null;
    }


}
