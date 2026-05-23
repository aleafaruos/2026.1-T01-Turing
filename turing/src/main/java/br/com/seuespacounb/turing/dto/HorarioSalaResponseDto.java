package br.com.seuespacounb.turing.dto;

import java.time.LocalDateTime;

public record HorarioSalaResponseDto(
        Long id,
        LocalDateTime inicio,
        LocalDateTime fim,
        String status,
        String descricaoOcupacao,
        Long salaId
) {}
