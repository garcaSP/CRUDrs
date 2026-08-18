package com.template.validator;

import com.template.model.TimesDTO;

public class TimesValidator {

    public ValidationResult validar(TimesDTO time) {
        boolean siglaValida = time.getSigla() != null
                && !time.getSigla().isBlank()
                && time.getSigla().length() <= 3;

        boolean nomeValido = time.getNome() != null && !time.getNome().isBlank();

        return new ValidationResult(siglaValida, nomeValido);
    }

    public static class ValidationResult {
        private final boolean siglaValida;
        private final boolean nomeValido;

        public ValidationResult(boolean siglaValida, boolean nomeValido) {
            this.siglaValida = siglaValida;
            this.nomeValido = nomeValido;
        }

        public boolean isSiglaValida() {
            return siglaValida;
        }

        public boolean isNomeValido() {
            return nomeValido;
        }

        public boolean isValido() {
            return siglaValida && nomeValido;
        }

        public String getMensagemErro() {
            if (!siglaValida) return "Sigla inválida! Deve ter entre 1 e 3 letras.";
            if (!nomeValido) return "Nome é obrigatório!";
            return null;
        }
    }
}
