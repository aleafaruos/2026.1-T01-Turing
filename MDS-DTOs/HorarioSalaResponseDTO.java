// aqui ele mostra os detalhes de um horario específico de ocupação da sala
package br.com.seuespacounb.turing.dto;

import br.com.seuespacounb.turing.entity.StatusHorario;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioSalaResponseDTO {
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private StatusHorario status;
    private String descricaoOcupacao;
    private Long salaId; // Devolve o ID da sala dona desse horário
}

