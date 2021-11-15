package dev.wandesson.resistence.rest.controller.dto;

import dev.wandesson.resistence.domain.entity.Localizacao;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AtualizarLocalizacaoDTO {
    private Localizacao novaLocalizacao;
}
