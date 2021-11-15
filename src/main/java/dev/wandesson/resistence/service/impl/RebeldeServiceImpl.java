package dev.wandesson.resistence.service.impl;

import dev.wandesson.resistence.domain.entity.Rebelde;
import dev.wandesson.resistence.domain.repository.RebeldeRepository;
import dev.wandesson.resistence.exception.RegraNegocioException;
import dev.wandesson.resistence.rest.controller.dto.AtualizarLocalizacaoDTO;
import dev.wandesson.resistence.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RebeldeServiceImpl implements RebeldeService {

    @Autowired
    private RebeldeRepository rebeldeRepository;


    @Override
    public Rebelde salvar(Rebelde rebelde) {
        return rebeldeRepository.save(rebelde);
    }

    @Override
    public Rebelde obterRebelde(Integer id) {
        return rebeldeRepository
                .findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException("Código de Rebelde não encontrado.")
                );
    }

    @Override
    public void atualizarLocalizacaoRebelde(AtualizarLocalizacaoDTO novaLocalizacao, Integer id) {
        rebeldeRepository
                .findById(id)
                .map(rebeldeExistente -> {
                    rebeldeExistente.setLocalizacao(novaLocalizacao.getNovaLocalizacao());
                    return rebeldeRepository.save(rebeldeExistente);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rebelde não encontrado"));
    }

    @Override
    public void indicarRebeldeTraidor(Integer idIndicado) {
        rebeldeRepository
                .findById(idIndicado)
                .map(rebeldeExistente -> {
                    rebeldeExistente.setIndicacoes(rebeldeExistente.getIndicacoes()+1);
                    if(rebeldeExistente.getIndicacoes() >= 3){
                        rebeldeExistente.setTraidor(true);
                    }
                    return rebeldeRepository.save(rebeldeExistente);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rebelde não encontrado"));
    }
}
