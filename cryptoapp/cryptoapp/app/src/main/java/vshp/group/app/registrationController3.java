package vshp.group.app;

import java.io.*;
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

                try(FileWriter writer = new FileWriter("temp.json", true)) {

                    String text = " :" + login + " : " + password;
                    writer.write(text);
                    writer.flush();
                    System.out.println(text);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


//                try (BufferedReader br = new BufferedReader(new FileReader("temp.json")))
//                {
//                    String lines;
//                    while ((lines = br.readLine()) != null) {
//                        String l = lines;
//                        String[] l1 = l.split(":");
//                        String SurName = l1[0];
//                        String Name = l1[1];
//                        String patronymic = l1[2];
//                        String age = l1[3];
//                        String number = l1[4];
//                        String email = l1[5];
//                        String logins = l1[6];
//                        String passwords = l1[7];
//
//                        System.out.println("Вставлено: " + SurName + Name + patronymic + age + number + email + logins + passwords);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                User user = new User();
                user.setLoginUser(login);
                user.setPasswordUser(password);


                buttonContinue.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/vshp/group/app/hello-view.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                signUpNewUser();

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

    protected void signUpNewUser(){
        DataBaseHandler dbHandler = new DataBaseHandler();

        try (BufferedReader br = new BufferedReader(new FileReader("temp.json")))
        {
            String lines;
            while ((lines = br.readLine()) != null) {
                String l = lines;
                String[] l1 = l.split(":");
                String SurName = l1[0];
                String Name = l1[1];
                String patronymic = l1[2];
                String age = l1[3];
                String number = l1[4];
                String email = l1[5];
                String login = l1[6];
                String password = l1[7];

            User user = new User(SurName, Name, patronymic, age, number, email, login, password);
           dbHandler.signUpUser(user);

                System.out.println("Вставлено: " + SurName + Name + patronymic + age + number + email + login + password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//
//        User user = new User();
//        String surname = user.getSurName();
//        String Name = user.getName();
//        String patronymic = user.getPatronymicName();
//        String age = user.getAgeUser();
//        String number = user.getPhoneUser();
//        String email = user.getEmailUser();
//        String login = user.getLoginUser();
//        String password = user.getPasswordUser();
//
//        User user1 = new User(surname, Name, patronymic, age, number, email, login, password);
//        dbHandler.signUpUser(user1);
    }

}
