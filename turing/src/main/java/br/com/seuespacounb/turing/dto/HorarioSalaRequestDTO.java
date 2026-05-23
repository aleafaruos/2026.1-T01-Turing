package br.com.seuespacounb.turing.dto;

import br.com.seuespacounb.turing.entity.Sala;

import java.time.LocalDateTime;

public record HorarioSalaRequestDTO(
    LocalDateTime inicio,
    LocalDateTime fim,
    String status,
    String descricaoOcupacao,
    Sala sala
) {}
