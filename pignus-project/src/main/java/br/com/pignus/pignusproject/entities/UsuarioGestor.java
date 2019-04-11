package br.com.pignus.pignusproject.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class UsuarioGestor extends Usuario {


}
