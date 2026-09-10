package com.template.factory;

import com.template.controller.MainController;
import com.template.service.TimesService;
import com.template.validator.ITimesValidador;
import javafx.util.Callback;

public class ControllerFactory implements Callback<Class<?>, Object> {

    private final ITimesValidador timesValidador;
    private final TimesService timesService;

    public ControllerFactory(ITimesValidador timesValidador, TimesService timesService) {
        this.timesValidador = timesValidador;
        this.timesService = timesService;
    }

    @Override
    public Object call(Class<?> tipoDoController) {
        if (tipoDoController == MainController.class) {
            return new MainController(timesValidador, timesService);
        }

        throw new IllegalArgumentException(
                "Controller não registrado na fábrica: " + tipoDoController.getName());
    }
}
