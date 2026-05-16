package br.com.seuespacounb.turing.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String emailInstTitucional;
    private String cpf;
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
