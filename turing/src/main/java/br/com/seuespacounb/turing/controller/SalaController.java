package br.com.seuespacounb.turing.controller;

import br.com.seuespacounb.turing.entity.Sala;
import br.com.seuespacounb.turing.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService service;

    @PostMapping
    public Sala salvarSala(@RequestBody Sala novaSala){
        return service.salvarSala(novaSala);
    }

    @GetMapping
    public List<Sala> listarSalas(){
        return service.listarSalas();
    }

    @GetMapping("/{id}")
    public Sala buscarSalaPorId(@PathVariable Long id){
        return service.buscarSalaPorId(id);
    }

    @PutMapping("/{id}")
    public Sala atualizarSala(
            @PathVariable Long id,
            @RequestBody Sala salaAtualizada){

        return service.atualizarSala(id, salaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarSala(@PathVariable Long id){
        service.deletarSala(id);
    }
}