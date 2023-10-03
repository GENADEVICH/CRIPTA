package vshp.group.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class registrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBackLogin;

    @FXML
    private Button buttonContinue321;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPatronymic;

    @FXML
    private TextField fieldSurname;

    @FXML
    private ToggleButton switchLogin;

    @FXML
    private ToggleButton switchRegister;




    @FXML
    void initialize() {

        switchLogin.setStyle("-fx-background-color: #0E0E10");


        switchRegister.setOnAction(actionEvent -> {
            if (switchRegister.isSelected()){
                switchLogin.setStyle("-fx-background-color: #0E0E10");

            } else switchRegister.setStyle("-fx-background-color: #2E591B");
        });

        switchLogin.setOnAction(actionEvent -> {
            if (switchLogin.isSelected()){
                switchRegister.setStyle("-fx-background-color: #0E0E10");

                switchLogin.getScene().getWindow().hide();


                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/vshp/group/app/hello-view.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();

            } else switchLogin.setStyle("-fx-background-color: #2E591B");
        });

        buttonContinue321.setOnAction(actionEvent -> {

            String name = fieldName.getText();
            String surname = fieldSurname.getText();
            String patronymic = fieldPatronymic.getText();

            if (name.isEmpty() || surname.isEmpty() || patronymic.isEmpty()){
                System.out.println("Чего-то не хватает");
            } else {
                buttonContinue321.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/vshp/group/app/registration2.fxml"));
                            try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.showAndWait();
                System.out.println("123");
            }
        });
    }
}
