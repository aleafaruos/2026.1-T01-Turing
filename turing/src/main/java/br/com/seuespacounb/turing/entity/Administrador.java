package br.com.seuespacounb.turing.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administradores")
public class Administrador extends Usuario {

}