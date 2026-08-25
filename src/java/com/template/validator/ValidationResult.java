package com.template.validator;

import java.util.LinkedHashMap;
import java.util.Map;

public class ValidationResult {

    private final Map<String, String> erros = new LinkedHashMap<>();

    public void adicionarErro(String campo, String mensagem) {
        erros.put(campo, mensagem);
    }

    public boolean isValido() {
        return erros.isEmpty();
    }

    public boolean isCampoValido(String campo) {
        return !erros.containsKey(campo);
    }

    public String getMensagemErro() {
        return erros.values().stream().findFirst().orElse(null);
    }
}
