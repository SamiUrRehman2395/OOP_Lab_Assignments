package com.example.labassignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private static final String CREDENTIALS_FILE = "credentials.txt";

    @Override
    public void start(Stage stage) {

        showLoginWindow(stage);
    }


    private void showLoginWindow(Stage stage) {


        BackgroundImage backgroundImage = new BackgroundImage(

                new Image("file:images/bgp.jpg"),

                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );



        ImageView bannerImageView = new ImageView();
        Image bannerImage = new Image("file:images/banner_image.jpg");

        bannerImageView.setImage(bannerImage);

        bannerImageView.setFitWidth(400);
        bannerImageView.setFitHeight(100);


        bannerImageView.setPreserveRatio(true);


        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");




        TextField passwordField = new TextField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (validateLogin(username, password)) {

                showUniversityForm(stage);
            } else {

                showErrorMessage("Invalid Username or Password.");
            }
        });



        VBox loginLayout = new VBox(10, bannerImageView, usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        loginLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");


        loginLayout.setBackground(new Background(backgroundImage));

        Scene loginScene = new Scene(loginLayout, 400, 300);
        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }


    private boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");

                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;



    }




    private void showErrorMessage(String message) {

        Stage errorStage = new Stage();

        Label errorMessageLabel = new Label(message);

        errorMessageLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: red; -fx-padding: 10px;");


        VBox layout = new VBox(10, errorMessageLabel);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");


        Scene errorScene = new Scene(layout, 250, 100);

        errorStage.setTitle("Invalid Login");
        errorStage.setScene(errorScene);
        errorStage.show();

    }


    private void showUniversityForm(Stage stage) {
        List<Person> formData = new ArrayList<>();


        ImageView bannerImageView = new ImageView();
        Image bannerImage = new Image("file:images/banner_image.jpg");
        bannerImageView.setImage(bannerImage);
        bannerImageView.setFitWidth(400);
        bannerImageView.setFitHeight(100);
        bannerImageView.setPreserveRatio(true);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();

        Label dobLabel = new Label("Date of Birth:");
        DatePicker dobPicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();

        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        VBox genderBox = new VBox(5, maleRadio, femaleRadio);

        Label cityLabel = new Label("City:");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Karachi", "Lahore", "Islamabad", "Peshawar", "Quetta");

        Label imageLabel = new Label("Image");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        Button browseButton = new Button("Browse");
        browseButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                imageView.setImage(new Image(file.toURI().toString()));
            }
        });

        VBox imageBox = new VBox(10, imageLabel, imageView, browseButton);

        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> stage.close());

        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dob = dobPicker.getValue() != null ? dobPicker.getValue().toString() : "Not Selected";
            String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Not Selected";
            String city = cityComboBox.getValue() != null ? cityComboBox.getValue() : "Not Selected";

            Person person = new Person(name, fatherName, cnic, dob, gender, city);
            formData.add(person);
            showConfirmationWindow(stage, person);
        });

        HBox buttonBox = new HBox(10, saveButton, exitButton);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setStyle("-fx-padding: 10;");

        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(fatherNameLabel, 0, 1);
        formGrid.add(fatherNameField, 1, 1);
        formGrid.add(cnicLabel, 0, 2);
        formGrid.add(cnicField, 1, 2);
        formGrid.add(dobLabel, 0, 3);
        formGrid.add(dobPicker, 1, 3);
        formGrid.add(genderLabel, 0, 4);
        formGrid.add(genderBox, 1, 4);
        formGrid.add(cityLabel, 0, 5);
        formGrid.add(cityComboBox, 1, 5);

        HBox bottomLayout = new HBox(20, formGrid, imageBox);
        VBox mainLayout = new VBox(10, bannerImageView, bottomLayout, buttonBox);

        Scene scene = new Scene(mainLayout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Data Entry Form");
        stage.show();
    }


    private void showConfirmationWindow(Stage owner, Person person) {
        Stage confirmationStage = new Stage();
        confirmationStage.initOwner(owner);

        Label messageLabel = new Label("Form submitted successfully!");
        Button printButton = new Button("Print Form");

        printButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Form Details");
            alert.setHeaderText("Submitted Form Data");
            alert.setContentText(person.toString());

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12;");
            alert.showAndWait();
        });

        VBox layout = new VBox(10, messageLabel, printButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(layout, 300, 200);

        confirmationStage.setScene(scene);
        confirmationStage.setTitle("Confirmation");
        confirmationStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

