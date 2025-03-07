package app;

import core.City;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parser.CityParser;
import util.CSVReader;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("C3 Project");
        primaryStage.setScene(new Scene(root, 640, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
