package com.template.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CamposObrigatoriosValidador implements Validador<List<String>> {

    private final List<String> valores;
    private final String mensagemErro;

    public CamposObrigatoriosValidador(String mensagemErro, String... valores) {
        this.mensagemErro = mensagemErro;
        this.valores = Arrays.asList(valores);
    }

    @Override
    public boolean validar() {
        for (String valor : valores) {
            if (valor == null || valor.isBlank()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getMensagemErro() {
        return mensagemErro;
    }

    @Override
    public List<String> getValor() {
        return Collections.unmodifiableList(valores);
    }
}
