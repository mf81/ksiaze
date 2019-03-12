package eu.maciejfijalkowski.ksiaze.Controllers;

import eu.maciejfijalkowski.ksiaze.Model.ModelDTO;
import eu.maciejfijalkowski.ksiaze.Property.Property;
import eu.maciejfijalkowski.ksiaze.Utils.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import eu.maciejfijalkowski.ksiaze.Model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    final Property name = new Property();
    final Property nameWMExploatation = new Property();
    final Property nameWMRenovation = new Property();
    final Property addressExploatation = new Property();
    final Property addressRenovation = new Property();
    final Property addressRent = new Property();
    final Property zipCity = new Property();
    final Property accountExploatation = new Property();
    final Property accountRenovation = new Property();
    final Property accountRent = new Property();


    private ModelDTO modelDTO = new ModelDTO();
    private IndexCount countIndex = IndexCount.getInstance();


    @FXML
    private Label labelWM, labelWM1, labelWM2, labelWMRenovation, labelWM1Renovation, labelWM2Renovation,
            labelAddress,labelAddress1, labelAddressRenovation, labelAddress1Renovation, labelAddressRent, labelAddress1Rent,
            labelZipCity, labelZipCityRenovation, labelZipCityRent,
            labelName,labelName1, labelNameRenovation, labelName1Renovation, labelNameRent, labelName1Rent, labelName11Rent,
            labelAccount,labelAccount1, labelAccountRenovation, labelAccount1Renovation, labelAccountRent, labelAccount1Rent,
            labelNumberCheck, labelNumberCheckRenovation, labelNumberCheckRent,
            labelIndex,labelIndex1, labelIndexRenovation, labelIndex1Renovation, labelIndexRent, labelIndex1Rent,
            labelIndexChange, labelIndexChangeRenovation, labelIndexOk, labelIndexOkRen;

    @FXML
    private TextField textFieldZipCity,textFieldWM, textFieldWMRenovation,textFieldAddress,
            textFieldAddressRenovation, textFieldName, textFieldAccount, textFieldAccountRenovation, textFieldAccountRent, textFieldAddressRent,
            textFieldDiffrentIndex,textFieldDiffrentIndexRenovation;

    @FXML
    private Button buttonPrintExploatation, buttonPrintRenovation, buttonPrintRent, buttonChangeIndexExp, buttonChangeIndexRen,buttonCopyChangeIndexRen;

    @FXML
    private ComboBox<Integer> comboBoxNumberOfPagesEx,comboBoxNumberOfPagesRenovation,comboBoxNumberOfPagesRent;

    @FXML
    private CheckBox chackBoxCoverExploatation,chackBoxCoverRenovation,chackBoxCoverRent, checkBoxIndex, getCheckBoxIndexRenovation;

    private Integer number = 0;
    private Boolean cover = true;
    private Boolean buttonCopyChange = false;


    @FXML
    private void labelNameExploatationKeyPress(KeyEvent event){
        nameWMExploatation.setLabel(textFieldWM.getText());
    }

    @FXML
    private void labelNameRenovationKeyPress(KeyEvent event){
        nameWMRenovation.setLabel(textFieldWMRenovation.getText());
    }

    @FXML
    private void labelAddressExploatationKeyPress(KeyEvent event){
        addressExploatation.setLabel(textFieldAddress.getText());
    }

    @FXML
    private void labelAddressRenovationKeyPress(KeyEvent event){
        addressRenovation.setLabel(textFieldAddressRenovation.getText());
    }

    @FXML
    private void labelAddressRentKeyPress(KeyEvent event){
        addressRent.setLabel(textFieldAddressRent.getText());
    }

    @FXML
    private void labelZipCityKeyPress(KeyEvent event){
        zipCity.setLabel(textFieldZipCity.getText());
    }

    @FXML
    private void labelNameKeyPress(KeyEvent event){
        name.setLabel(textFieldName.getText());
    }

    @FXML
    private void labelAccountKeyPress(KeyEvent event){
        accountExploatation.setLabel(textFieldAccount.getText());
    }



    public void initialize(URL location, ResourceBundle resources) {

        checkBoxIndex.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                textFieldDiffrentIndex.requestFocus();
                textFieldDiffrentIndex.selectAll();
                labelIndexChange.setText("Wpisz inny INDEX lokalu:");
                textFieldDiffrentIndex.setEditable(true);
                buttonChangeIndexExp.setDisable(false);
                buttonCopyChange = true;
            }
            else {
                labelIndexChange.setText("Proponowany INDEX lokalu:");
                labelIndexOk.setText("");
                textFieldDiffrentIndex.setEditable(false);
                buttonChangeIndexExp.setDisable(true);
                textFieldDiffrentIndex.textProperty().setValue(countIndex.count(textFieldAccount.textProperty().get()));
                countIndex.setIndex(countIndex.count(textFieldAccount.textProperty().get()));
                labelIndex.textProperty().setValue(countIndex.getIndex());
                labelIndex1.textProperty().setValue(countIndex.getIndex());
                labelIndex.textProperty().setValue(countIndex.getIndex());
                labelIndex1.textProperty().setValue(countIndex.getIndex());
                buttonCopyChange = false;

            }
        });

        getCheckBoxIndexRenovation.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                textFieldDiffrentIndexRenovation.requestFocus();
                textFieldDiffrentIndexRenovation.selectAll();
                labelIndexChangeRenovation.setText("Wpisz inny INDEX lokalu:");
                textFieldDiffrentIndexRenovation.setEditable(true);
                buttonChangeIndexRen.setDisable(false);
                if (buttonCopyChange)
                        buttonCopyChangeIndexRen.setDisable(false);
                    else
                        buttonCopyChangeIndexRen.setDisable(true);
            }
            else {
                labelIndexChangeRenovation.setText("Proponowany INDEX lokalu:");
                labelIndexOkRen.setText("");
                textFieldDiffrentIndexRenovation.setEditable(false);
                buttonChangeIndexRen.setDisable(true);
                buttonCopyChangeIndexRen.setDisable(true);
                textFieldDiffrentIndexRenovation.textProperty().setValue(countIndex.count(textFieldAccountRenovation.textProperty().get()));
                countIndex.setIndex(countIndex.count(textFieldAccountRenovation.textProperty().get()));
                labelIndexRenovation.textProperty().setValue(countIndex.getIndex());
                labelIndex1Renovation.textProperty().setValue(countIndex.getIndex());

            }
        });

        chackBoxCoverExploatation.selectedProperty().addListener((observable, oldValue, newValue) -> cover = newValue);

        comboBoxNumberOfPagesEx.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> number = (Integer)newValue);

        chackBoxCoverRenovation.selectedProperty().addListener((observable, oldValue, newValue) -> cover = newValue);

        comboBoxNumberOfPagesRenovation.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> number = (Integer)newValue);

        chackBoxCoverRent.selectedProperty().addListener((observable, oldValue, newValue) -> cover = newValue);

        comboBoxNumberOfPagesRent.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> number=(Integer)newValue);

        nameWMExploatation.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelWM.textProperty().bind(textFieldWM.textProperty());
            labelWM.setWrapText(true);
            labelWM1.textProperty().bind(textFieldWM.textProperty());
            labelWM2.textProperty().bind(textFieldWM.textProperty());
            labelWM2.setWrapText(true);
        });

        nameWMRenovation.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelWMRenovation.textProperty().bind(textFieldWMRenovation.textProperty());
            labelWMRenovation.setWrapText(true);
            labelWM1Renovation.textProperty().bind(textFieldWMRenovation.textProperty());
            labelWM2Renovation.textProperty().bind(textFieldWMRenovation.textProperty());
            labelWM2Renovation.setWrapText(true);
        });

        addressExploatation.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelAddress.textProperty().bind(textFieldAddress.textProperty());
            labelAddress1.textProperty().bind(textFieldAddress.textProperty());
        });

        addressRenovation.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelAddressRenovation.textProperty().bind(textFieldAddressRenovation.textProperty());
            labelAddress1Renovation.textProperty().bind(textFieldAddressRenovation.textProperty());
        });

        addressRent.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelAddressRent.textProperty().bind(textFieldAddressRent.textProperty());
            labelAddress1Rent.textProperty().bind(textFieldAddressRent.textProperty());
        });

        zipCity.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelZipCity.textProperty().bind(textFieldZipCity.textProperty());
            labelZipCityRenovation.textProperty().bind(textFieldZipCity.textProperty());
            labelZipCityRent.textProperty().bind(textFieldZipCity.textProperty());
        });

        name.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelName.textProperty().bind(textFieldName.textProperty());
            labelName1.textProperty().bind(textFieldName.textProperty());
            labelNameRenovation.textProperty().bind(textFieldName.textProperty());
            labelName1Renovation.textProperty().bind(textFieldName.textProperty());
            labelNameRent.textProperty().bind(textFieldName.textProperty());
            labelName1Rent.textProperty().bind(textFieldName.textProperty());
            labelName11Rent.textProperty().bind(textFieldName.textProperty());
        });

        accountExploatation.labelTextProperty().addListener((observable, oldValue, newValue) -> {
            labelAccount.textProperty().bind(textFieldAccount.textProperty());
            labelAccount1.textProperty().bind(textFieldAccount.textProperty());
        });
    }

    @FXML
    private void buttonCheckNumberExploatation(ActionEvent event){
        NrbUtils nrbUtils = new NrbUtils(textFieldAccount.getText());

        if(nrbUtils.correctAccountNumber()){
            textFieldAccount.setText(nrbUtils.getAccountNumberWithSpaces());
            accountExploatation.setLabel(textFieldAccount.getText());
            labelAccount.textProperty().bind(textFieldAccount.textProperty());
            labelAccount1.textProperty().bind(textFieldAccount.textProperty());
            labelNumberCheck.setText("Numer konta jest OK ;-)");
            labelNumberCheck.setTextFill(Color.GREEN);
            buttonPrintExploatation.setDisable(false);

            textFieldDiffrentIndex.textProperty().setValue(countIndex.count(textFieldAccount.textProperty().get()));
            labelIndex.textProperty().setValue(countIndex.count(textFieldAccount.textProperty().get()));
            labelIndex1.textProperty().setValue(countIndex.count(textFieldAccount.textProperty().get()));
        }
        else{
            buttonPrintExploatation.setDisable(true);
            labelNumberCheck.setText("BŁĄD NUMERU KONTA !!! :-(");
            labelNumberCheck.setTextFill(Color.RED);
            labelIndex.textProperty().setValue("");
            labelIndex1.textProperty().setValue("");
        }
    }

    @FXML
    private void buttonCheckNumberRenovation(ActionEvent event){
        NrbUtils nrbUtils = new NrbUtils(textFieldAccountRenovation.getText());

        if(nrbUtils.correctAccountNumber()){
            textFieldAccountRenovation.setText(nrbUtils.getAccountNumberWithSpaces());
            accountRenovation.setLabel(textFieldAccountRenovation.getText());
            labelAccountRenovation.textProperty().bind(textFieldAccountRenovation.textProperty());
            labelAccount1Renovation.textProperty().bind(textFieldAccountRenovation.textProperty());
            labelNumberCheckRenovation.setText("Numer konta jest OK ;-)");
            labelNumberCheckRenovation.setTextFill(Color.GREEN);
            buttonPrintRenovation.setDisable(false);


            textFieldDiffrentIndexRenovation.textProperty().setValue(countIndex.count(textFieldAccountRenovation.textProperty().get()));
            labelIndexRenovation.textProperty().setValue(countIndex.count(textFieldAccountRenovation.textProperty().get()));
            labelIndex1Renovation.textProperty().setValue(countIndex.count(textFieldAccountRenovation.textProperty().get()));
        }
        else{
            buttonPrintRenovation.setDisable(true);
            labelNumberCheckRenovation.setText("BŁĄD NUMERU KONTA !!! :-(");
            labelNumberCheckRenovation.setTextFill(Color.RED);
            labelIndexRenovation.textProperty().setValue("");
            labelIndex1Renovation.textProperty().setValue("");
        }

    }

    @FXML
    private void buttonCheckNumberRent(ActionEvent event){
        NrbUtils nrbUtils = new NrbUtils(textFieldAccountRent.getText());

        if(nrbUtils.correctAccountNumber()){
            textFieldAccountRent.setText(nrbUtils.getAccountNumberWithSpaces());
            accountRent.setLabel(textFieldAccountRent.getText());
            labelAccountRent.textProperty().bind(textFieldAccountRent.textProperty());
            labelAccount1Rent.textProperty().bind(textFieldAccountRent.textProperty());
            labelNumberCheckRent.setText("Numer konta jest OK ;-)");
            labelNumberCheckRent.setTextFill(Color.GREEN);
            buttonPrintRent.setDisable(false);

            labelIndexRent.textProperty().setValue(countIndex.count(textFieldAccountRent.textProperty().get()));
            labelIndex1Rent.textProperty().setValue(countIndex.count(textFieldAccountRent.textProperty().get()));
        }
        else{
            buttonPrintRent.setDisable(true);
            labelNumberCheckRent.setText("BŁĄD NUMERU KONTA !!! :-(");
            labelNumberCheckRent.setTextFill(Color.RED);
            labelIndexRent.textProperty().setValue("");
            labelIndex1Rent.textProperty().setValue("");
        }
    }

    @FXML
    public void buttonPrintExploatationStart() throws IOException {
        modelDTO.add(textFieldName, textFieldAccount,textFieldWM,textFieldAddress, textFieldZipCity);

        PrinterBooklet printerBooklet = new PrinterBooklet();
        FillBlankBooklet fillBlankBooklet = new FillBlankBooklet();

        Node coverToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankCoverExploatation.fxml");
        fillBlankBooklet.setBlankBooklet(coverToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        Node bookletToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankBooklet.fxml");
        fillBlankBooklet.setBlankBooklet(bookletToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        printerBooklet.start(coverToPrint,bookletToPrint,cover,number,buttonPrintExploatation);
    }

    @FXML
    public void buttonPrintRenovationStart() throws IOException {
        modelDTO.add(textFieldName, textFieldAccount,textFieldWM,textFieldAddress, textFieldZipCity);

        PrinterBooklet printerBooklet = new PrinterBooklet();
        FillBlankBooklet fillBlankBooklet = new FillBlankBooklet();

        Node coverToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankCoverRenovation.fxml");
        fillBlankBooklet.setBlankBooklet(coverToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        Node bookletToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankBooklet.fxml");
        fillBlankBooklet.setBlankBooklet(bookletToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        printerBooklet.start(coverToPrint,bookletToPrint,cover,number,buttonPrintRenovation);
    }

    @FXML
    public void buttonPrintRentStart() throws IOException {
        modelDTO.add(textFieldName, textFieldAccount,textFieldWM,textFieldAddress, textFieldZipCity);

        PrinterBooklet printerBooklet = new PrinterBooklet();
        FillBlankBooklet fillBlankBooklet = new FillBlankBooklet();

        Node coverToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankCoverRent.fxml");
        fillBlankBooklet.setBlankBooklet(coverToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        Node bookletToPrint = printerBooklet.fxmlPrintingSchemaLoader("blankBookletRent.fxml");
        fillBlankBooklet.setBlankBooklet(bookletToPrint);
        fillBlankBooklet.setUpBooklet(modelDTO);

        printerBooklet.start(coverToPrint,bookletToPrint,cover,number, buttonPrintRent);
    }

    @FXML
    private void buttonChangeIndexExpStart(){
        labelIndexOk.setTextFill(Color.GREEN);
        labelIndexOk.setText("OK ;-) zmieniony");
        countIndex.setIndex(textFieldDiffrentIndex.textProperty().get());
        labelIndex.textProperty().setValue(textFieldDiffrentIndex.textProperty().get());
        labelIndex1.textProperty().setValue(textFieldDiffrentIndex.textProperty().get());

    }

    @FXML
    private void buttonChangeIndexRenStart(){
        labelIndexOkRen.setTextFill(Color.GREEN);
        labelIndexOkRen.setText("OK ;-) zmieniony");
        countIndex.setIndex(textFieldDiffrentIndexRenovation.textProperty().get());
        labelIndexRenovation.textProperty().setValue(textFieldDiffrentIndexRenovation.textProperty().get());
        labelIndex1Renovation.textProperty().setValue(textFieldDiffrentIndexRenovation.textProperty().get());

    }

    @FXML
    private void buttonCopyStart(){
        textFieldWMRenovation.textProperty().setValue(textFieldWM.textProperty().get());
        textFieldAddressRenovation.textProperty().setValue(textFieldAddress.textProperty().get());

        labelWMRenovation.textProperty().setValue(textFieldWM.textProperty().get());
        labelWMRenovation.setWrapText(true);
        labelWM1Renovation.textProperty().setValue(textFieldWM.textProperty().get());
        labelWM2Renovation.textProperty().setValue(textFieldWM.textProperty().get());
        labelWM2Renovation.setWrapText(true);

        labelAddressRenovation.textProperty().setValue(textFieldAddress.textProperty().get());
        labelAddress1Renovation.textProperty().setValue(textFieldAddress.textProperty().get());
    }

    @FXML
    private void buttonCopyChangeIndexRenStart(){
        textFieldDiffrentIndexRenovation.textProperty().setValue(textFieldDiffrentIndex.textProperty().get());
        labelIndexRenovation.textProperty().setValue(textFieldDiffrentIndex.textProperty().get());
        labelIndex1Renovation.textProperty().setValue(textFieldDiffrentIndex.textProperty().get());
        countIndex.setIndex(textFieldDiffrentIndex.textProperty().get());
    }
}
