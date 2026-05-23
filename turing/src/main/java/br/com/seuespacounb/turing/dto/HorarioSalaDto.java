package br.com.seuespacounb.turing.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class HorarioSalaDto {

    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String status;
    private String descricaoOcupacao;
    private Long salaId;
}
