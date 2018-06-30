package com.palmarcell.controllers;

import com.palmarcell.dao.impl.PassDAOImpl;
import com.palmarcell.model.PassEntity;
import com.palmarcell.service.PassService;
import com.palmarcell.service.impl.PassServiceImpl;
import com.palmarcell.utility.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang3.RandomStringUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class mainScreenController implements Initializable {

    @FXML
    public TableView<PassEntity> pwList;
    @FXML
    public TableColumn<PassEntity, String> siteCol;
    @FXML
    public TableColumn<PassEntity, String> pwCol;
    @FXML
    public TableColumn<PassEntity, Long> idCol;
    @FXML
    public TextField siteName;
    @FXML
    public TextField generatedPw;

    private PassService passService = new PassServiceImpl(new PassDAOImpl(Manager.getInstance()));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        siteCol.setCellValueFactory(new PropertyValueFactory<>("siteName"));
        pwCol.setCellValueFactory(new PropertyValueFactory<>("pass"));

        ObservableList<PassEntity> archive = FXCollections.observableList(passService.getPasses());

        pwList.setItems(archive);
    }

    @FXML
    public void generate(ActionEvent actionEvent) throws Exception {

        generatedPw.setText(RandomStringUtils.randomAscii(14));

    }

    @FXML
    public void savePw(ActionEvent actionEvent) {

        if(!siteName.getText().isEmpty() && !generatedPw.getText().isEmpty()) {

            PassEntity passEntity = new PassEntity(siteName.getText(),generatedPw.getText());

            passService.addPw(passEntity);

            pwList.getItems().add(passEntity);

            siteName.clear();
            generatedPw.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba!");
            alert.setHeaderText("Valamelyik mező üres maradt!");
            alert.setContentText("Ellenőrízze a mentendő adatokat.");
            alert.showAndWait();
        }
    }
}
