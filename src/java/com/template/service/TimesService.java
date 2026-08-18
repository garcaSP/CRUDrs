package com.template.service;

import com.template.model.TimesDAO;
import com.template.model.TimesDTO;
import com.template.validator.TimesValidator;

import java.util.List;

public class TimesService {

    private final TimesDAO timesDAO = new TimesDAO();
    private final TimesValidator timesValidator = new TimesValidator();

    public List<TimesDTO> listarTimes() {
        return timesDAO.listarTimes();
    }

    public TimesValidator.ValidationResult cadastrarTime(TimesDTO time) {
        TimesValidator.ValidationResult resultado = timesValidator.validar(time);
        if (resultado.isValido()) {
            timesDAO.cadastrarTime(time);
        }
        return resultado;
    }

    public TimesValidator.ValidationResult atualizarTime(TimesDTO time) {
        TimesValidator.ValidationResult resultado = timesValidator.validar(time);
        if (resultado.isValido()) {
            timesDAO.atualizarTime(time);
        }
        return resultado;
    }

    public void deletarTime(int id) {
        timesDAO.deletarTime(id);
    }
}
