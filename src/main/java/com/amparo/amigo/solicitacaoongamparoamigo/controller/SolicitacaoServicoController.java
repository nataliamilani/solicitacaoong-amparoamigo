package com.amparo.amigo.solicitacaoongamparoamigo.controller;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import com.amparo.amigo.solicitacaoongamparoamigo.service.SolicitacaoSevicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitacao_servico")
public class SolicitacaoServicoController {

    private final SolicitacaoSevicoService solicitacaoService;

    public SolicitacaoServicoController(SolicitacaoSevicoService solicitacaoService) { this.solicitacaoService = solicitacaoService; }

    @PostMapping
    public SolicitacaoServico criarSolicitacao(@RequestBody SolicitacaoServico solicitacao) {
        return solicitacaoService.criarSolicitacao(solicitacao);
    }

    @GetMapping(path = "solicitacao/{solicitacaoId}")
    public Optional<SolicitacaoServico> consultarSolicitacaoBySolicitacaoId(@PathVariable("solicitacaoId") Integer solicitacaoId) {
        return solicitacaoService.consultarSolicitacaoBySolicitacaoId(solicitacaoId);
    }

    @GetMapping(path = "voluntario/{voluntarioId}")
    public List<SolicitacaoServico> consultarSolicitacaoByVoluntarioId(@PathVariable("voluntarioId") Integer voluntarioId) {
        return solicitacaoService.consultarSolicitacaoByVoluntarioId(voluntarioId);
    }
}
