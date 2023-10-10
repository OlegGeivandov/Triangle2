package com.example.triangle2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HelloController {
    @FXML
    private Label areaLbl;

    @FXML
    private TextField sideA;

    @FXML
    private TextField sideB;

    @FXML
    private TextField sideC;

    @FXML
    private Button areaCalculateBtn;

    @FXML
    private Button loadFromFileAndCalculateBtn;

    Triangle tr;
    ArrayList<Triangle> triangles = new ArrayList<>();
    Double sumArea=0.0;






    @FXML
    public void readTriangle() {
        try {
            tr = new Triangle(Double.parseDouble(sideA.getText()), Double.parseDouble(sideB.getText()), Double.parseDouble(sideC.getText()));
            if (!tr.isTriangle) areaLbl.setText("Это не треугольник");
            else areaLbl.setText("Площадь треугольника  " + tr.area);
        }
        catch (NumberFormatException e) {
            areaLbl.setText("Необходимы вещественные числа");
        }
    }

    @FXML
    public void loadFromFileAndCalculate() throws IOException {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);
//        areaLbl.setText(file.getName());
        List<String> list = Files.readAllLines(file.toPath());
        for (String str: list) {
            String[] words = str.split(" ");
            for (int i = 0; i < words.length; i++) {
                tr = new Triangle(Double.parseDouble(words[0]), Double.parseDouble(words[1]), Double.parseDouble(words[2]));
                triangles.add(tr);
//                sumArea += tr.area;
            }
        }
        sumArea = triangles.stream()
                .mapToDouble(x->x.area)
                .sum();
        areaLbl.setText("Сумма площадей треугольников  " + sumArea);
    }



}