package com.amparo.amigo.solicitacaoongamparoamigo.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SolicitacaoNotFoundException extends RuntimeException {

    public SolicitacaoNotFoundException(String msg) {super(msg);}
}
