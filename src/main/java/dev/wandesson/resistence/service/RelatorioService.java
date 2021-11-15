package dev.wandesson.resistence.service;

import dev.wandesson.resistence.rest.controller.dto.PercentualDTO;

public interface RelatorioService {
    PercentualDTO obterPercentualTraidores();
    PercentualDTO obterPercentualRebeldes();
    Integer obterPontosPerdidosTraidores();
}
