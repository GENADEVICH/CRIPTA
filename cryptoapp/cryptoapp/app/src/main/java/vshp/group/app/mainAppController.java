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



    }

}

