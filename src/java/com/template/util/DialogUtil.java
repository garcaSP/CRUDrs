package com.template.util;

import javafx.scene.control.Label;

public class DialogUtil {

    private DialogUtil() {
    }

    public static void exibirSucesso(Label label, String mensagem) {
        exibirMensagem(label, mensagem, "#7CFC7C");
    }

    public static void exibirErro(Label label, String mensagem) {
        exibirMensagem(label, mensagem, "#FF6B6B");
    }

    public static void limparMensagem(Label label) {
        label.setText("");
    }

    private static void exibirMensagem(Label label, String mensagem, String cor) {
        label.setText(mensagem);
        label.setStyle("-fx-text-fill: " + cor + ";");
    }
}
