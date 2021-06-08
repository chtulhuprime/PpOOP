package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Cube { //creating cube
    private final Box box = new Box();
    private double cubeSize;
    private String cubeColor;

    Box createCube(){
        box.setWidth(getCubeSize());
        box.setHeight(getCubeSize());
        box.setDepth(getCubeSize());

        PhongMaterial mat = new PhongMaterial();
        mat.setSpecularColor(Color.WHITE);
        mat.setDiffuseColor(Color.valueOf(getCubeColor()));

        box.setMaterial(mat);

        Rotate yRotation = new Rotate(25, Rotate.Y_AXIS);
        box.setRotationAxis(Rotate.Y_AXIS);
        box.getTransforms().addAll(yRotation);

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

    public double getCubeSize() {
        return cubeSize;
    }

    public void setCubeSize(double cubeSize) {
        this.cubeSize = cubeSize;
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

    public String getCubeColor() {
        return cubeColor;
    }
}