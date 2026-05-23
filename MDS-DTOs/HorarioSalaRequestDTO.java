// aqui o sistema é responsavel por controlar o que é enviado para o usuário (horario)
package br.com.seuespacounb.turing.dto;

import br.com.seuespacounb.turing.entity.StatusHorario;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioSalaRequestDTO {
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private StatusHorario status;
    private String descricaoOcupacao;
    private Long salaId; // Vincula o horário pelo ID da sala
}