package com.template.validator;

public class SomenteLetrasValidador implements Validador<String> {

    private final String campo;
    private final String valor;

    public SomenteLetrasValidador(String campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    @Override
    public boolean validar() {
        if (valor == null || valor.isBlank()) {
            return false;
        }
        return valor.trim().matches("[\\p{L} ]+");
    }

    @Override
    public String getMensagemErro() {
        return campo + " deve conter apenas letras.";
    }

    @Override
    public String getValor() {
        return valor;
    }
}
