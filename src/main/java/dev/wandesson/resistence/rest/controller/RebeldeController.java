package dev.wandesson.resistence.rest.controller;

import dev.wandesson.resistence.domain.entity.Rebelde;
import dev.wandesson.resistence.domain.repository.RebeldeRepository;
import dev.wandesson.resistence.rest.controller.dto.AtualizarLocalizacaoDTO;
import dev.wandesson.resistence.service.RebeldeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/rebeldes/")
public class RebeldeController {

    @Autowired
    private RebeldeService rebeldeService;

    @GetMapping("{id}")
    @Operation(summary = "Obtem dados de um Rebelde através do id")
    public Rebelde getRebeldeById(@PathVariable Integer id){
        return rebeldeService.obterRebelde(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra um novo Rebelde")
    public Rebelde saveRebelde(@RequestBody Rebelde rebelde){
        return rebeldeService.salvar(rebelde);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Atualiza apenas a localização de um Rebelde")
    public void atualizarLocalizacao(@RequestBody AtualizarLocalizacaoDTO novaLocalizacao, @PathVariable Integer id){
        rebeldeService.atualizarLocalizacaoRebelde(novaLocalizacao, id);
    }

    @PostMapping("indicar-traidor/{id}")
    @Operation(summary = "Reporta um determinado Rebelde como traidor")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void indicarTraidor(@PathVariable Integer id){
        rebeldeService.indicarRebeldeTraidor(id);
    }
}
