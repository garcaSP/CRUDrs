package com.template.validator;

import com.template.model.TimesDTO;

public class SiglaValidador implements Validador<TimesDTO> {

    @Override
    public boolean isValido(TimesDTO time) {
        return time.getSigla() != null
                && !time.getSigla().isBlank()
                && time.getSigla().length() <= 3;
    }

    @Override
    public String getCampo() {
        return "sigla";
    }

    @Override
    public String getMensagemErro() {
        return "Sigla inválida! Deve ter entre 1 e 3 letras.";
    }
}
