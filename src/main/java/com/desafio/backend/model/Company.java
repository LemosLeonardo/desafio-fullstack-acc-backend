package com.desafio.backend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company extends Address{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 14, nullable = false, unique=true)
    private String cnpj;

    @Column(nullable = false)
    private String nomeFantasia;

    @ManyToMany(fetch = FetchType.EAGER)
    List<VendorPJ> vendors;

    public List<VendorPJ> getVendors() {
        return vendors;
    }

    public void setVendors(List<VendorPJ> vendors) {
        this.vendors = vendors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
