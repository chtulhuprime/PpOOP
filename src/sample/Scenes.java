package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;


public class Scenes {
    private Scene menu, cube;
    private Button btn;
    private final Slider slider = new Slider(200.0, 600.0, 200.0);
    private final ObservableList<String> colors = FXCollections.observableArrayList("Синий", "Красный", "Желтый", "Зеленый");
    private final ChoiceBox<String> colorsChoiceBox = new ChoiceBox<>(colors);
    private final Cube cube1 = new Cube();
    private Box box = new Box();
    private final Label lbl = new Label();
    private final Label lbl2 = new Label();
    private int size = 200;


    public Scene getMenuScene() {
        return menu;
    }

    public void setMenuScene(Stage stage) {
        lbl.setText("Выберите размер куба");
        lbl.setTranslateX(20);

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(25.0);
        slider.setMajorTickUnit(25.0);
        slider.setMinorTickCount(25);
        slider.setSnapToTicks(true);

        lbl2.setText("Выберите цвет");
        lbl2.setTranslateX(20);

        colorsChoiceBox.setTranslateX(20);
        colorsChoiceBox.setValue("Синий");
        cube1.setCubeColor(colorsChoiceBox.getValue());
        colorsChoiceBox.setOnAction(event -> cube1.setCubeColor(colorsChoiceBox.getValue()));

        btn = new Button("Show");
        btn.setTranslateX(75);
        btn.setOnAction(e ->{
            slider.valueProperty().addListener((changed, oldValue, newValue) -> size = newValue.intValue());
            cube1.setCubeSize(size);
            box = cube1.createCube();
            cube1.animateCube(box);
            setCubeScene(stage);
            stage.setScene(getCubeScene());
        });

        VBox layout1 = new VBox();
        layout1.setSpacing(10);
        layout1.getChildren().addAll(lbl, slider, lbl2, colorsChoiceBox, btn);
        menu = new Scene(layout1, 200, 200);
    }

    public Scene getCubeScene() {
        return cube;
    }

    public void setCubeScene(Stage stage) {
        btn = new Button("Go back");
        btn.setOnAction(e -> stage.setScene(getMenuScene()));
        StackPane.setAlignment(btn, Pos.TOP_LEFT);

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(btn,box);
        cube = new Scene(layout2, cube1.getCubeSize()+300, cube1.getCubeSize()+300);
    }
}