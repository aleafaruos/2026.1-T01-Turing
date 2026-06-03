package br.com.seuespacounb.turing.dto;

import br.com.seuespacounb.turing.validation.groups.OnCreate;
import br.com.seuespacounb.turing.validation.groups.OnUpdate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public record HorarioSalaRequestDTO(
        @NotNull(message = "O campo 'inicioPeriodo' não pode está vazio",
                groups = OnCreate.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate inicioPeriodo,

        @NotNull(message = "O campo 'fimPeriodo' não pode está vazio",
                groups = OnCreate.class)
        @Future(message = "A data selecionada não é válida",
                groups = OnCreate.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate fimPeriodo,

        @NotNull(message = "O campo 'diaSemana' não pode está vazio",
                groups = OnCreate.class)
        DayOfWeek diaSemana,

        @NotNull(message = "O campo 'inicioHora' não pode está vazio",
                groups = OnCreate.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        LocalTime inicioHora,

        @NotNull(message = "O campo 'fimHora' não pode está vazio",
                groups = OnCreate.class)
        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
        LocalTime fimHora,

        @NotNull(message = "O campo 'status' não pode está vazio",
                groups = {OnCreate.class, OnUpdate.class})
        String status,

        @NotBlank(message = "O campo 'descriçãoOcupacao' não pode está vazio",
                groups = OnCreate.class)
        String descricaoOcupacao,

        @NotNull(message = "O campo 'salaId' não pode está vazio",
                groups = OnCreate.class)
        Long salaId
) {}
