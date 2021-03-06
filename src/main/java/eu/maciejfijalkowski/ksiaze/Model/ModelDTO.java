package eu.maciejfijalkowski.ksiaze.Model;


import eu.maciejfijalkowski.ksiaze.Utils.IndexCount;
import javafx.scene.control.TextField;

public class ModelDTO {
    Model model;

    public ModelDTO (){
        this.model = Model.getInstance();
    }

    public void add (TextField textFieldName, TextField textFieldAccount, TextField textFieldWM,
                     TextField textFieldAddress, TextField textFieldZipCity, TextField textFieldIndex){

        model.setName(textFieldName.textProperty().get());
        model.setAccount(textFieldAccount.textProperty().get());
        model.setNameWM(textFieldWM.textProperty().get());
        model.setAddress(textFieldAddress.textProperty().get());
        model.setZipCity(textFieldZipCity.textProperty().get());
        model.setIndex(textFieldIndex.textProperty().get());

    }

    public void add (TextField textFieldName, TextField textFieldAccount,
                     TextField textFieldAddress, TextField textFieldZipCity, TextField textFieldIndex){

        model.setName(textFieldName.textProperty().get());
        model.setAccount(textFieldAccount.textProperty().get());
        model.setAddress(textFieldAddress.textProperty().get());
        model.setZipCity(textFieldZipCity.textProperty().get());
        model.setIndex(textFieldIndex.textProperty().get());

    }

    public Model getModel(){
        return model;
    }
}
