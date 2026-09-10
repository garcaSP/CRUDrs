package com.template.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {

    private final List<String> erros = new ArrayList<>();

    public void adicionarErro(String mensagem) {
        erros.add(mensagem);
    }

    public boolean isValido() {
        return erros.isEmpty();
    }

    public List<String> getErros() {
        return Collections.unmodifiableList(erros);
    }

    public String getMensagemErro() {
        return String.join("\n", erros);
    }
}
