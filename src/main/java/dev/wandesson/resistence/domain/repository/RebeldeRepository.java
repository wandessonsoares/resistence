package dev.wandesson.resistence.domain.repository;

import dev.wandesson.resistence.domain.entity.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RebeldeRepository extends JpaRepository<Rebelde, Integer> {

    @Query("select r from Rebelde r where r.traidor = true")
    List<Rebelde> findRebeldesTraidores();

    @Query("select r from Rebelde r where r.traidor = false")
    List<Rebelde> findRebeldesVerdadeiros();
}
