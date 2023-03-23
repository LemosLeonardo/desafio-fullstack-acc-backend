package com.desafio.backend.controller;

import com.desafio.backend.model.VendorPJ;
import com.desafio.backend.repository.VendorPJRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vendor/pj")
public class VendorPJController {

    private VendorPJRepository vendorPJRepository;

    public VendorPJController(VendorPJRepository vendorPJRepository) {
        this.vendorPJRepository = vendorPJRepository;
    }

    @GetMapping
    public List<VendorPJ> list() {
        return vendorPJRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorPJ> findById(@PathVariable String id) {
        return vendorPJRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/total")
    public Long getCount() {
        return vendorPJRepository.count();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public VendorPJ create(@RequestBody VendorPJ vendorPJ) {
        return vendorPJRepository.save(vendorPJ);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorPJ> update(@PathVariable String id, @RequestBody VendorPJ vendorPJ) {
        return vendorPJRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setCnpj(vendorPJ.getCnpj());
                    recordFound.setNomeFantasia(vendorPJ.getNomeFantasia());
                    recordFound.setEmail(vendorPJ.getEmail());
                    recordFound.setDataAbertura(vendorPJ.getDataAbertura());
                    recordFound.setEmail(vendorPJ.getEmail());
                    recordFound.setCep(vendorPJ.getCep());
                    recordFound.setUf(vendorPJ.getUf());
                    recordFound.setCidade(vendorPJ.getCidade());
                    recordFound.setBairro(vendorPJ.getBairro());
                    recordFound.setLogradouro(vendorPJ.getLogradouro());
                    recordFound.setNumero(vendorPJ.getNumero());
                    recordFound.setComplemento(vendorPJ.getComplemento());

                    VendorPJ updated = vendorPJRepository.save(recordFound);

                    return ResponseEntity.ok().body(updated);

                })
                .orElse(ResponseEntity.notFound().build());

//                    .map(recordFound -> {
//                    recordFound.setNome(vendorPJ.getNome());
//                    recordFound.setCpf(vendorPJ.getCpf());
//                    recordFound.setRg(vendorPJ.getRg());
//                    recordFound.setDataNascimento(vendorPJ.getDataNascimento());
//                    recordFound.setEmail(vendorPJ.getEmail());
//                    recordFound.setCep(vendorPJ.getCep());
//                    recordFound.setUf(vendorPJ.getUf());
//                    recordFound.setCidade(vendorPJ.getCidade());
//                    recordFound.setBairro(vendorPJ.getBairro());
//                    recordFound.setLogradouro(vendorPJ.getLogradouro());
//                    recordFound.setNumero(vendorPJ.getNumero());
//                    recordFound.setComplemento(vendorPJ.getComplemento());
//
//                    VendorPJ updated = vendorPJRepository.save(recordFound);
//
//                    return  ResponseEntity.ok().body(updated);
//
//                })
//                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vendorPJRepository.findById(id)
                .map(recordFound -> {
                    vendorPJRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
        return null;
    }

}
