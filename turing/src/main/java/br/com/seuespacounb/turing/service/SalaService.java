package br.com.seuespacounb.turing.service;

import br.com.seuespacounb.turing.entity.Sala;
import br.com.seuespacounb.turing.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository repository;

    public Sala salvarSala(Sala novaSala){
        return repository.saveAndFlush(novaSala);
    }

    public Sala buscarSalaPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
    }

    public List<Sala> listarSalas(){
        return repository.findAll();
    }

    public Sala atualizarSala(Long id, Sala salaAtualizada){

        Sala salaExistente = buscarSalaPorId(id);

        salaExistente.setNome(salaAtualizada.getNome());
        salaExistente.setCapacidade(salaAtualizada.getCapacidade());
        salaExistente.setLocalizacao(salaAtualizada.getLocalizacao());

        return repository.saveAndFlush(salaExistente);
    }

    public void deletarSala(Long id){
        repository.deleteById(id);
    }
    public List<Sala> filtrarPorNome(String nome){
    return repository.findByNomeContainingIgnoreCase(nome);
    }
}
