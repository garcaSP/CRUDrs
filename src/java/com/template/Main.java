package com.template;

import com.template.factory.ControllerFactory;
import com.template.model.TimesDAO;
import com.template.service.TimesService;
import com.template.validator.ITimesValidador;
import com.template.validator.TimesValidador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));

        loader.setControllerFactory(criarFabricaDeControllers());

        Scene scene = new Scene(loader.load(), 679, 400);

        stage.setTitle("Sistema CRUD - Times");
        stage.setScene(scene);
        stage.show();
    }

    private ControllerFactory criarFabricaDeControllers() {
        ITimesValidador timesValidador = new TimesValidador();
        TimesService timesService = new TimesService(new TimesDAO());

        return new ControllerFactory(timesValidador, timesService);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
