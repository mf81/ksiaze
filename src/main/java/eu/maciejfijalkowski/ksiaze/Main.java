package eu.maciejfijalkowski.ksiaze;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainWindowSmall.fxml"));
        primaryStage.setTitle("Książe");

        Scene scene = new Scene(root, 1200, 750);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("css/bootstrap3.css").toExternalForm());

        primaryStage.getIcons().add(new Image("/jpgs/icon.png"));

        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
