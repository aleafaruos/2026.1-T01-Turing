package br.com.seuespacounb.turing.controller;

import br.com.seuespacounb.turing.dto.HorarioSalaRequestDto;
import br.com.seuespacounb.turing.dto.HorarioSalaResponseDto;
import br.com.seuespacounb.turing.service.HorarioSalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@RequiredArgsConstructor

public class HorarioController {

    private final HorarioSalaService horarioSalaService;

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<HorarioSalaResponseDto>> buscarPorSala(@PathVariable Long salaId) {
        List<HorarioSalaResponseDto> horarios = horarioSalaService.listarHorariosPorSala(salaId);
        return ResponseEntity.ok(horarios);
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody HorarioSalaRequestDto horarioSalaRequestDto) {
        horarioSalaService.salvarHorario(horarioSalaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Horário agendado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        horarioSalaService.excluirHorario(id);
        return ResponseEntity.ok("Horário removido");
    }
}
