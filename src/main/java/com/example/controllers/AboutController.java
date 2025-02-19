package com.example.controllers;

import java.io.IOException;

import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AboutController {

    @FXML
    void backToMain(ActionEvent event) throws IOException {
        App.setRoot("mainScene");
    }

}
