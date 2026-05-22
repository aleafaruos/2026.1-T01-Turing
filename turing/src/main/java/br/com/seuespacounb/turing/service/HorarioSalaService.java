package br.com.seuespacounb.turing.service;

import br.com.seuespacounb.turing.entity.HorarioSala;
import br.com.seuespacounb.turing.entity.Sala;
import br.com.seuespacounb.turing.exception.ConflictException;
import br.com.seuespacounb.turing.repository.HorarioSalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioSalaService {
    private final HorarioSalaRepository repository;

    //mudar para o DTO depois
    public HorarioSala salvarHorario(HorarioSala novoHorario) throws ConflictException {
        List<HorarioSala> horariosDaSala = buscarHoraPorSala(novoHorario.getSala());
        boolean conflitoHorario = horariosDaSala.stream()
                .anyMatch(
                        horarioExistente -> novoHorario.getInicio().isBefore(horarioExistente.getFim())
                        && novoHorario.getFim().isAfter(horarioExistente.getInicio()));
        if(conflitoHorario) {
            throw new ConflictException("Infelizmente não foi possivel salvar este horário para esta sala, pois houve conflito de horário");
        }
        return repository.saveAndFlush(novoHorario);
    }

    public List<HorarioSala> buscarHoraPorSala(Sala sala){
        return repository.findBySala(sala);
    }

    public void deletarHorarioPorSala(Sala sala){
        repository.deleteBySala(sala);
    }


}
