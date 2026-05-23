package br.com.seuespacounb.turing.dto;

public record SalaRequestDTO(
        String nome,
        int capacidade,
        String localizacao
) {}
