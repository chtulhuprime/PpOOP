package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Cube { //creating cube
    private final Box box = new Box();
    private String cubeColor;

    public Box prepareCube(double cubeSize){
        cubeSize = 200 + (cubeSize-1)*50;

        box.setWidth(cubeSize);
        box.setHeight(cubeSize);
        box.setDepth(cubeSize);

        PhongMaterial clr = new PhongMaterial();
        clr.setSpecularColor(Color.WHITE);
        clr.setDiffuseColor(Color.valueOf(cubeColor));

        box.setMaterial(clr);

        box.setRotationAxis(Rotate.Y_AXIS);

        return box;
    }

    void animateCube(Box box){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                box.setRotate(box.getRotate() + 0.3);
            }
        };
        timer.start();
    }

    public void setCubeColor(String cubeColor) {
        switch (cubeColor) {
            case "Синий" -> cubeColor = "BLUE";
            case "Красный" -> cubeColor = "RED";
            case "Желтый" -> cubeColor = "YELLOW";
            case "Зеленый" -> cubeColor = "GREEN";
        }
        this.cubeColor = cubeColor;
    }
}