package com.template.validator;

public class TamanhoTextoValidador implements Validador<String> {

    private final String campo;
    private final String valor;
    private final int minimo;
    private final int maximo;

    public TamanhoTextoValidador(String campo, String valor, int minimo, int maximo) {
        this.campo = campo;
        this.valor = valor;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean validar() {
        if (valor == null) {
            return false;
        }
        int tamanho = valor.trim().length();
        return tamanho >= minimo && tamanho <= maximo;
    }

    @Override
    public String getMensagemErro() {
        return campo + " deve ter entre " + minimo + " e " + maximo + " caracteres.";
    }

    @Override
    public String getValor() {
        return valor;
    }
}
