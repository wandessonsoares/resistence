package dev.wandesson.resistence.service.impl;

import dev.wandesson.resistence.domain.entity.Rebelde;
import dev.wandesson.resistence.domain.entity.Recurso;
import dev.wandesson.resistence.domain.repository.RebeldeRepository;
import dev.wandesson.resistence.rest.controller.dto.PercentualDTO;
import dev.wandesson.resistence.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Autowired
    private RebeldeRepository rebeldeRepository;

    @Override
    public PercentualDTO obterPercentualTraidores() {
        Integer totalRebeldes = rebeldeRepository.findAll().size();

        Integer totalRebeldesTraidores = rebeldeRepository.findRebeldesTraidores().size();

        float percentual = (float)(totalRebeldesTraidores*100)/totalRebeldes;
        PercentualDTO percentualDTO = new PercentualDTO(String.format("%,.2f", percentual));

        return percentualDTO;
    }

    @Override
    public PercentualDTO obterPercentualRebeldes() {
        Integer totalRebeldes = rebeldeRepository.findAll().size();

        Integer totalRebeldesVerdadeiros = rebeldeRepository.findRebeldesVerdadeiros().size();

        float percentual = (float)(totalRebeldesVerdadeiros*100)/totalRebeldes;
        PercentualDTO percentualDTO = new PercentualDTO(String.format("%,.2f", percentual));

        return percentualDTO;
    }

    @Override
    public Integer obterPontosPerdidosTraidores() {
        List<Rebelde> rebeldesTraidores = rebeldeRepository.findRebeldesTraidores();

        Integer totalPontos = 0;

        for(Rebelde r: rebeldesTraidores){
            for(Recurso recurso: r.getRecursos()){
                totalPontos += recurso.getPontos();
            }
        }

        return totalPontos;
    }
}
