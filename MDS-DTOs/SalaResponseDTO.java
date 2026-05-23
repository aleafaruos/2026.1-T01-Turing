// aqui o sistema é responsavel por controlar o que é enviado para o usuário
package br.com.seuespacounb.turing.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaResponseDTO {
    private Long id;
    private String nome;
    private int capacidade;
    private String localizacao;
    private List<HorarioSalaResponseDTO> horarios; // Entrega os horários da sala limpos
}
// no HorarioSalaResponseDTO, 
// o DTO garante que o usuário só receba exatamente o que é necessário 
