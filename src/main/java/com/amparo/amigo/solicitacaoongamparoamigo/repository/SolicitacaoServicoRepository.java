package com.amparo.amigo.solicitacaoongamparoamigo.repository;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Integer> {

    Optional<SolicitacaoServico> findBySolicitacaoId(Integer solicitacaoId);
}
