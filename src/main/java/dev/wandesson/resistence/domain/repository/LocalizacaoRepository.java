package dev.wandesson.resistence.domain.repository;

import dev.wandesson.resistence.domain.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

}
