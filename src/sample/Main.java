package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;

        Scenes scene = new Scenes();
        scene.setMenuScene(window);

        window.setScene(scene.getMenuScene());
        window.setTitle("PpOOP");
        window.getIcons().add(new Image("file:cube.png"));
        window.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}