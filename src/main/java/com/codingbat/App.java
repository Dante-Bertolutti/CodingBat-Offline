package com.codingbat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.codingbat.ui.MainView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getRoot(), 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/com/codingbat/css/theme.css").toExternalForm());

        stage.setTitle("CodingBat Offline");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/codingbat/logo.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
