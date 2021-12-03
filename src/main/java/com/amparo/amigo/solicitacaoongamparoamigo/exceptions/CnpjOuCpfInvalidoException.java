package com.amparo.amigo.solicitacaoongamparoamigo.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CnpjOuCpfInvalidoException extends RuntimeException {

    public CnpjOuCpfInvalidoException (String msg) {super(msg);}
}
