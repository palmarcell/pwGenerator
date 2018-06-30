package com.palmarcell;

import com.palmarcell.utility.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainScreen.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        Manager.getInstance();
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        Manager.getInstance().close();
    }

}
