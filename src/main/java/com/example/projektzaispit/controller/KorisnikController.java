package com.example.projektzaispit.controller;

import com.example.projektzaispit.Program;
import com.example.projektzaispit.model.Table;
import com.example.projektzaispit.model.auto;
import com.example.projektzaispit.model.korisnik;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KorisnikController implements Initializable {
    @FXML

    protected void korisnikAdministration (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "intro-view.fxml", "Nazad");
        System.out.println("Hello");
    }

    @FXML

    protected void autoAdministration (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "auto-view.fxml", "DodajAuto");
        System.out.println("Hello");
    }


    @FXML
    TextField nameTxt;

    @FXML
    TextField surnameTxt;

    @FXML
    TextField JMBGTxt;

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnFirstname;

    @FXML
    TableColumn tableColumnLastname;

    @FXML
    TableColumn tableColumnJMBG;

    @FXML
    TableView tableViewKorisnici;

    @FXML
    Button deleteBtn;

    korisnik selectedKorisnik;

    @FXML
    protected void selectKorisnik(){
        this.selectedKorisnik = (korisnik) this.tableViewKorisnici.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.nameTxt.setText(this.selectedKorisnik.getFirstname());
        this.surnameTxt.setText(this.selectedKorisnik.getLastname());
        this.JMBGTxt.setText(this.selectedKorisnik.getJMBG());

    }
    @FXML
    protected void deleteKorisnik() throws Exception {
        if (this.selectedKorisnik != null){
            this.selectedKorisnik.delete();
            this.fillKorisnici();

        }
    }



    @FXML

    protected void saveKorisnik () throws Exception {
        if(this.selectedKorisnik == null) {
            korisnik newKorisnik = new korisnik();
            newKorisnik.setFirstname(this.nameTxt.getText());
            newKorisnik.setLastname(this.surnameTxt.getText());
            newKorisnik.setJMBG(this.JMBGTxt.getText());
            newKorisnik.save();
        } else {
            this.selectedKorisnik.setFirstname(this.nameTxt.getText());
            this.selectedKorisnik.setLastname(this.surnameTxt.getText());
            this.selectedKorisnik.setJMBG(this.JMBGTxt.getText());
            this.selectedKorisnik.update();
            this.selectedKorisnik = null;
        }
        this.fillKorisnici();
        this.nameTxt.setText("");
        this.surnameTxt.setText("");
        this.JMBGTxt.setText("");
    }

    private void fillKorisnici (){
        try {
            ObservableList<korisnik> korisnici = (ObservableList<korisnik>) FXCollections.observableArrayList(Table.list(korisnik.class));
            this.tableViewKorisnici.setItems(korisnici);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.tableColumnLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tableColumnJMBG.setCellValueFactory(new PropertyValueFactory<>("JMBG"));
        this.fillKorisnici();




    }
}
