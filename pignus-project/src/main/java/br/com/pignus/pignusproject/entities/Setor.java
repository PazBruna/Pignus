package br.com.pignus.pignusproject.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.entities.UsuarioGestor;


@Entity
public class Setor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    
    @Column(unique=true, nullable=false)
    private String nomeSetor;
    private Empresa empresa;
    private UsuarioGestor gestor;


    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getNomeSetor(){
        return this.nomeSetor;
    }

    public void setNomeSetor(String nomeSetor){
        this.nomeSetor = nomeSetor;
    }

    public Empresa getEmpresa(){
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public UsuarioGestor getUsuarioGestor(){
        return this.gestor;
    }

    public void setUsuarioGestor(UsuarioGestor gestor){
        this.gestor = gestor;
    }
}