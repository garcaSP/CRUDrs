package com.template.service;

import com.template.model.TimesDAO;
import com.template.model.TimesDTO;

import java.util.List;

public class TimesService {

    private final TimesDAO timesDAO;

    public TimesService(TimesDAO timesDAO) {
        this.timesDAO = timesDAO;
    }

    public List<TimesDTO> listarTimes() {
        return timesDAO.listarTimes();
    }

    public void cadastrarTime(TimesDTO time) {
        timesDAO.cadastrarTime(time);
    }

    public void atualizarTime(TimesDTO time) {
        timesDAO.atualizarTime(time);
    }

    public void deletarTime(int id) {
        timesDAO.deletarTime(id);
    }
}
