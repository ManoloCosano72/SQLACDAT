package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioController extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrerButton;
    @FXML
    private ImageView exitButton;
    @Override
    public void onOpen(Object input) throws Exception {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void goToLogin() throws Exception {
        App.currentController.changeScene(Scenes.LOGIN,null);
    }
    @FXML
    private void goToRegistrer() throws Exception {
        App.currentController.changeScene(Scenes.REGISTRER,null);
    }
    @FXML
    private void closeApp() {
        System.exit(0);
    }
}
