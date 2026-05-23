//aqui é onde o DTO controla tudo que é requisitado no sistema vindo de fora
package br.com.seuespacounb.turing.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaRequestDTO {
    private String nome;
    private int capacidade;
    private String localizacao;
}
// aqui o DTO garante que o usuário só mande exatamente o que é necessário para criar
//uma sala
