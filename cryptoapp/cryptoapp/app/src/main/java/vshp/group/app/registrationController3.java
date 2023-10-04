package vshp.group.app;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class registrationController3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBackLogin;

    @FXML
    private Button buttonContinue;

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private PasswordField fieldSecondPass;

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



        buttonContinue.setOnAction(actionEvent -> {
            String login = fieldLogin.getText();
            String password = fieldPassword.getText();
            String confirmPass = fieldSecondPass.getText();

            if (login.isEmpty() || (!password.equals(confirmPass))) {
                System.out.println("wrong");

            } else {

                try(FileWriter writer = new FileWriter("temp.json", false)) {

                    String text = " :" + login + " : " + password;
                    writer.write(text);
                    writer.flush();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                buttonContinue.getScene().getWindow().hide();
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
