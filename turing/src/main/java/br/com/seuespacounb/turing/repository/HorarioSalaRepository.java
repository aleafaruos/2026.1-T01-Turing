package br.com.seuespacounb.turing.repository;

import br.com.seuespacounb.turing.entity.HorarioSala;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HorarioSalaRepository extends JpaRepository<HorarioSala, Long> {

    List<HorarioSala> findBySalaId(Long sala_id);

    @Transactional
    void deleteBySalaId(Long sala_id);
}
