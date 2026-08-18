package com.template.util;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DialogUtil {

    private static final String ESTILO_CAMPO_INVALIDO = "-fx-border-color: red; -fx-border-width: 2px;";

    private DialogUtil() {
    }

    public static void exibirSucesso(Label label, String mensagem) {
        exibirMensagem(label, mensagem, "green");
    }

    public static void exibirErro(Label label, String mensagem) {
        exibirMensagem(label, mensagem, "red");
    }

    private static void exibirMensagem(Label label, String mensagem, String cor) {
        label.setText(mensagem);
        label.setStyle("-fx-text-fill: " + cor + ";");
    }

    public static void marcarCampoInvalido(TextField campo) {
        campo.setStyle(ESTILO_CAMPO_INVALIDO);
    }

    public static void limparEstiloCampo(TextField campo) {
        campo.setStyle("");
    }
}
