package com.amparo.amigo.solicitacaoongamparoamigo.controller;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import com.amparo.amigo.solicitacaoongamparoamigo.service.SolicitacaoSevicoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitacao_servico")
public class SolicitacaoServicoController {

    private final SolicitacaoSevicoService solicitacaoService;

    public SolicitacaoServicoController(SolicitacaoSevicoService solicitacaoService) { this.solicitacaoService = solicitacaoService; }

    @PostMapping
    public SolicitacaoServico criarSolicitacao(@RequestBody SolicitacaoServico solicitacao) {
        return solicitacaoService.criarSolicitacao(solicitacao);
    }

    @GetMapping(path = "/{solicitacaoId}")
    public SolicitacaoServico consultarSolicitacaoId(@PathVariable("solicitaoId") Integer solicitacaoId) {
        return solicitacaoService.consultarServicoId(solicitacaoId);
    }
}
