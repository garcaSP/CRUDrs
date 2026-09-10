package com.template.validator;

import com.template.model.TimesDTO;

import java.util.ArrayList;
import java.util.List;

public class TimesValidador implements ITimesValidador {

    private final List<Validador<?>> validadores = new ArrayList<>();

    @Override
    public ValidationResult validar(TimesDTO time) {
        montarValidadores(time);

        ValidationResult resultado = new ValidationResult();

        for (Validador<?> validador : validadores) {
            if (!validador.validar()) {
                resultado.adicionarErro(validador.getMensagemErro());
            }
        }

        return resultado;
    }

    private void montarValidadores(TimesDTO time) {
        validadores.clear();

        validadores.add(new CamposObrigatoriosValidador(
                "Os campos Sigla e Nome são obrigatórios.",
                time.getSigla(), time.getNome()));

        validadores.add(new TamanhoTextoValidador("Sigla", time.getSigla(), 2, 3));
        validadores.add(new SomenteLetrasValidador("Sigla", time.getSigla()));
        validadores.add(new TamanhoTextoValidador("Nome", time.getNome(), 3, 60));
    }
}
