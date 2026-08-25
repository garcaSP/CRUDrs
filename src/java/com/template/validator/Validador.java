package com.template.validator;

public interface Validador<T> {

    boolean isValido(T objeto);

    String getCampo();

    String getMensagemErro();
}
