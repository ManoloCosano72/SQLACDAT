package com.github.ManoloCosano72.view;

public enum Scenes {
    INICIO("inicio.fxml"),
    LOGIN("login.fxml"),
    REGISTRER("registrer.fxml"),
    MAIN("main.fxml"),
    CLIENTE("cliente.fxml"),
    TRABAJADOR("trabajador.fxml"),
    QUITARPIEZALISTA("quitarPiezaLista.fxml"),
    ANADIRPIEZALISTA("anadirPiezaLista.fxml");
    private final String url;

    Scenes(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
