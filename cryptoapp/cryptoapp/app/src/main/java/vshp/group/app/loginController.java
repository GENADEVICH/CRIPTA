package vshp.group.app;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private Button buttonAuth;

    @FXML
    private Button buttonRegister;

    @FXML
    private Button createAcc;


    @FXML
    void initialize() {
        buttonRegister.setStyle("-fx-background-color: #0E0E10");

        buttonRegister.setOnAction(actionEvent -> {
            buttonRegister.setStyle("-fx-background-radius: 14; -fx-background-color: #2E591B");
            buttonAuth.setStyle("-fx-background-color: #0E0E10");

            buttonRegister.getScene().getWindow().hide();

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
        });

        buttonAuth.setOnAction(actionEvent -> {
            buttonAuth.setStyle("-fx-background-radius: 14; -fx-background-color: #2E591B");

            buttonRegister.setStyle("-fx-background-color: #0E0E10");
        });

        buttonLogin.setOnAction(actionEvent -> {
            String login = fieldLogin.getText();
            String email = fieldEmail.getText();
            String password = fieldPassword.getText();

            if (login.isEmpty() || email.isEmpty() || password.isEmpty()){
                System.out.println("Проверьте верность ввода");
            } else {
                System.out.println(login + " " +password+" "+email);

                loginUser(login,password,email);


            }
        });

        createAcc.setOnAction(actionEvent -> {
            createAcc.getScene().getWindow().hide();

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
        });
    }

    private void  loginUser(String login, String password, String email){


        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        User user = new User();
        user.setLoginUser(login);
        user.setEmailUser(email);
        user.setPasswordUser(password);
        ResultSet result = dataBaseHandler.getUser(user);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {throw new RuntimeException(e);}
            counter++;
        }
        if (counter >=1 ){

            System.out.println("Найден!");

            buttonLogin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vshp/group/app/mainApp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {throw new RuntimeException(e);}
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setFullScreen(true);
            stage.show();

        } else {
            System.out.println("Нету");
        }
    }
}

