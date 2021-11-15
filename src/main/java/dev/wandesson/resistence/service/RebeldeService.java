package dev.wandesson.resistence.service;

import dev.wandesson.resistence.domain.entity.Rebelde;
import dev.wandesson.resistence.rest.controller.dto.AtualizarLocalizacaoDTO;

public interface RebeldeService {
    Rebelde salvar(Rebelde rebelde);
    Rebelde obterRebelde(Integer id);
    void atualizarLocalizacaoRebelde(AtualizarLocalizacaoDTO novaLocalizacao, Integer id);
    void indicarRebeldeTraidor(Integer idIndicado);
}
