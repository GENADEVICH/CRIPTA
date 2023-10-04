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
    private Button buttonAuth;


    @FXML
    private Button buttonRegister;




    @FXML
    void initialize() {

        buttonAuth.setStyle("-fx-background-color: #0E0E10");

        buttonRegister.setOnAction(actionEvent -> {
            buttonRegister.setStyle("-fx-background-radius: 14; -fx-background-color: #2E591B");
            buttonAuth.setStyle("-fx-background-color: #0E0E10");

        });

        buttonAuth.setOnAction(actionEvent -> {
            buttonAuth.setStyle("-fx-background-radius: 14; -fx-background-color: #2E591B");

            buttonRegister.setStyle("-fx-background-color: #0E0E10");

            buttonAuth.getScene().getWindow().hide();

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
                stage.show();
                System.out.println("123");
            }
        });

        buttonBackLogin.setOnAction(actionEvent -> {
            buttonBackLogin.getScene().getWindow().hide();
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
        });
    }
}
