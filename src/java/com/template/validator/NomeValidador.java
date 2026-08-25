package com.template.validator;

import com.template.model.TimesDTO;

public class NomeValidador implements Validador<TimesDTO> {

    @Override
    public boolean isValido(TimesDTO time) {
        return time.getNome() != null && !time.getNome().isBlank();
    }

    @Override
    public String getCampo() {
        return "nome";
    }

    @Override
    public String getMensagemErro() {
        return "Nome é obrigatório!";
    }
}
