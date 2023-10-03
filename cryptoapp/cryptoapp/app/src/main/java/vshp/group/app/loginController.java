package vshp.group.app;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;


    @FXML
    private Text noAccText;

    @FXML
    private ToggleButton switchLogin;

    @FXML
    private ToggleButton switchRegister;

    @FXML
    void initialize() {
        switchRegister.setStyle("-fx-background-color: #0E0E10");

        switchRegister.setOnAction(actionEvent -> {
            if (switchRegister.isSelected()){
                switchLogin.setStyle("-fx-background-color: #0E0E10");

                switchRegister.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/vshp/group/app/registration1.fxml"));
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

            } else switchRegister.setStyle("-fx-background-color: #2E591B");
        });

        switchLogin.setOnAction(actionEvent -> {
            if (switchLogin.isSelected()){
                switchRegister.setStyle("-fx-background-color: #0E0E10");
            } else switchLogin.setStyle("-fx-background-color: #2E591B");
        });

        buttonLogin.setOnAction(actionEvent -> {
            String login = fieldLogin.getText();
            String email = fieldEmail.getText();
            String password = fieldPassword.getText();

            if (login.isEmpty() || email.isEmpty() || password.isEmpty()){
                System.out.println("Проверьте верность ввода");
            } else {
                System.out.println(login + " " +password+" "+email);
            }
        });
    }
}