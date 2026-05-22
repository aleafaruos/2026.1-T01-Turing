package br.com.seuespacounb.turing.repository;

import br.com.seuespacounb.turing.entity.HorarioSala;
import br.com.seuespacounb.turing.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HorarioSalaRepository extends JpaRepository<HorarioSala, Long> {
    List<HorarioSala> findBySala(Sala sala);
    void deleteBySala(Sala sala);
}
