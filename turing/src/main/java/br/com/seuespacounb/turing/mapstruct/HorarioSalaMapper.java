package br.com.seuespacounb.turing.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.seuespacounb.turing.dto.HorarioSalaRequestDTO;
import br.com.seuespacounb.turing.dto.HorarioSalaResponseDTO;
import br.com.seuespacounb.turing.entity.HorarioSala;

@Mapper(componentModel = "spring")
public interface HorarioSalaMapper {

    HorarioSala paraHoriaroSala(HorarioSalaRequestDTO dto);

    @Mapping(source = "sala.id", target = "salaId")
    HorarioSalaResponseDTO praHorarioResponseDTO(HorarioSala entity);
    List<HorarioSalaResponseDTO> paraListHorarioResponseDTO(List<HorarioSala> entities);
}