/**
 * 
 */
package UI;

/**
 * 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankingUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title for the stage
        primaryStage.setTitle("Banking Management System");

        // Creating a GridPane layout
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);

        // Username label and text field
        Label userNameLabel = new Label("Username:");
        TextField userNameField = new TextField();
        grid.add(userNameLabel, 0, 0);
        grid.add(userNameField, 1, 0);

        // Password label and password field
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        // Login button
        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 2);

        // Set the scene with grid layout
        Scene scene = new Scene(grid, 400, 250);

        // Setting the scene to the stage
        primaryStage.setScene(scene);

        // Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
