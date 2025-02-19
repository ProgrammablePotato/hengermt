package com.example.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.App;
import com.example.DataBaseConnector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController {
    Double radius;
    Double height;
    Double surface;

    @FXML
    private TextField heightField;

    @FXML
    private TextField radiusField;

    @FXML
    private TextField surfaceField;

    @FXML
    private ImageView imgView;

    @FXML
    void calculate(ActionEvent event) throws FileNotFoundException {
        String str = startCalculate();
        surfaceField.setText(str);
        if (surface != null) {
            setImage("happy.png");;
        }
        else {
            setImage("coding.jpg");;
        }
    }

    @FXML
    void toAbout(ActionEvent event) throws IOException {
        App.setRoot("aboutScene");
    }

    @FXML
    void saveData(ActionEvent event) {
        DataBaseConnector db = new DataBaseConnector();
        db.connect();
    }

    String startCalculate() {
        try {
            surface = calculateSurface();
        } catch (NumberFormatException e) {
            surface = null;
            return "Kérlek, helyes adatot adj meg!";
        }
        String out = "%.2f";
        return String.format(out,surface);
    }
    Double calculateSurface() throws NumberFormatException, NullPointerException {
        radius = Double.valueOf(radiusField.getText());
        height = Double.valueOf(heightField.getText());
        return 2*Math.PI*radius*(radius+height);
    }

    void setImage(String name) throws FileNotFoundException {
        //Valami baja volt ha az elérési utat az Image osztály konstruktorában adtam meg ezért lett ilyen ronda :(
        //Tudom a képek nem részei az elvárásoknak, de gondoltam kipróbálom :D
        imgView.setImage(new Image(new FileInputStream(new File(String.format("src\\main\\resources\\com\\example\\images\\%s",name)))));
    }
}
