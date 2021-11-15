package dev.wandesson.resistence.rest.controller;

import dev.wandesson.resistence.rest.controller.dto.PercentualDTO;
import dev.wandesson.resistence.rest.controller.dto.PontosPerdidosDTO;
import dev.wandesson.resistence.service.RelatorioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorios/")
public class RelatoriosController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("percentual-traidores")
    @Operation(summary = "Obtem o percentual de traidores")
    public ResponseEntity<PercentualDTO> getPercentualRebeldesTraidores(){
         PercentualDTO percentualTraidores = relatorioService.obterPercentualTraidores();

         return new ResponseEntity<PercentualDTO>(percentualTraidores, HttpStatus.OK);
    }

    @GetMapping("percentual-rebeldes")
    @Operation(summary = "Obtem o percentual de rebeldes, sem contar os traidores")
    public ResponseEntity<PercentualDTO> getPercentualRebeldesVerdadeiros(){
        PercentualDTO percentualRebeldes = relatorioService.obterPercentualRebeldes();

        return new ResponseEntity<PercentualDTO>(percentualRebeldes, HttpStatus.OK);
    }

    @GetMapping("pontos-perdidos-traidores")
    @Operation(summary = "Obtem a quantidade de pontos perdidos por traidores")
    public ResponseEntity<PontosPerdidosDTO> getPontosPerdidosPorTraidores(){
        Integer pontosPerdidos = relatorioService.obterPontosPerdidosTraidores();
        PontosPerdidosDTO pontosPerdidosDTO = new PontosPerdidosDTO(pontosPerdidos);

        return new ResponseEntity<PontosPerdidosDTO>(pontosPerdidosDTO, HttpStatus.OK);
    }
}
