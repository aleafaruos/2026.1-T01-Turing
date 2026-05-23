package br.com.seuespacounb.turing.service;

import br.com.seuespacounb.turing.dto.HorarioSalaRequestDTO;
import br.com.seuespacounb.turing.dto.HorarioSalaResponseDTO;
import br.com.seuespacounb.turing.entity.HorarioSala;
import br.com.seuespacounb.turing.entity.StatusHorario;
import br.com.seuespacounb.turing.exception.ConflictException;
import br.com.seuespacounb.turing.mapstruct.HorarioSalaMapper;
import br.com.seuespacounb.turing.repository.HorarioSalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioSalaService {
    private final HorarioSalaRepository repository;
    private final HorarioSalaMapper mapper;

    //mudar para o DTO depois
    public HorarioSalaResponseDTO salvarHorario(HorarioSalaRequestDTO horarioRequestDTO)throws ConflictException {
        List<HorarioSala> horariosDaSala = repository.findBySalaId(horarioRequestDTO.sala().getId());
        boolean conflitoHorario = horariosDaSala.stream()
                .anyMatch(
                        horarioExistente -> horarioRequestDTO.inicio().isBefore(horarioExistente.getFim())
                        && horarioRequestDTO.fim().isAfter(horarioExistente.getInicio()));
        if(conflitoHorario) {
            throw new ConflictException("Infelizmente não foi possivel salvar este horário para esta sala, pois houve conflito de horário");
        }
        HorarioSala novoHorario = mapper.paraHoriaroSala(horarioRequestDTO);
        novoHorario.setStatus(StatusHorario.VAGO);
        return mapper.praHorarioResponseDTO(repository.saveAndFlush(novoHorario));
    }

    public List<HorarioSalaResponseDTO> listarHorariosPorSala(Long sala_id){
        return mapper.paraListHorarioResponseDTO(repository.findBySalaId(sala_id));
    }

    public void excluirHorarioPorSala(Long sala_id){
        repository.deleteBySalaId(sala_id);
    }


}
