package com.template.validator;

import com.template.model.TimesDTO;

import java.util.List;

public class TimesValidator {

    private final List<Validador<TimesDTO>> validadores = List.of(
            new SiglaValidador(),
            new NomeValidador()
    );

    public ValidationResult validar(TimesDTO time) {
        ValidationResult resultado = new ValidationResult();

        for (Validador<TimesDTO> validador : validadores) {
            if (!validador.isValido(time)) {
                resultado.adicionarErro(validador.getCampo(), validador.getMensagemErro());
            }
        }

        return resultado;
    }
}
