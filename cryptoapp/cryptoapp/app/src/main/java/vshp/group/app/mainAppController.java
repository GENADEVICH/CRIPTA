package vshp.group.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class mainAppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<?, ?> chartGraph;

    @FXML
    private Button coinOne;

    @FXML
    private Button coinThree;

    @FXML
    private Button coinTwo;

    @FXML
    private Text textBalance;

    @FXML
    private Text textName;

    @FXML
    private Text textSurname;

    @FXML
    void initialize() {
        assert chartGraph != null : "fx:id=\"chartGraph\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert coinOne != null : "fx:id=\"coinOne\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert coinThree != null : "fx:id=\"coinThree\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert coinTwo != null : "fx:id=\"coinTwo\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert textBalance != null : "fx:id=\"textBalance\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert textName != null : "fx:id=\"textName\" was not injected: check your FXML file 'mainApp.fxml'.";
        assert textSurname != null : "fx:id=\"textSurname\" was not injected: check your FXML file 'mainApp.fxml'.";

    }

}

