package eu.maciejfijalkowski.ksiaze.Utils;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FillBlankBooklet {
    Label name;
    Label account;
    Label nameWmCover;
    Label adress;
    Label zipCity;
    Label index;

    Node bookletToPrint;

    public FillBlankBooklet() {
    }

    public FillBlankBooklet(Node bookletToPrint){
        this.bookletToPrint=bookletToPrint;
    }

    public void setBlankBooklet(Node bookletToPrint){
        this.bookletToPrint=bookletToPrint;
    }

    public void setUpBooklet(TextField textName, TextField textAccount, TextField textFieldWM,
                TextField textFieldAddress, TextField textZipCity,String textIndex){

        name = (Label) bookletToPrint.lookup("#labelName");
        if (name!=null) name.setText(textName.getText());

        account = (Label) bookletToPrint.lookup("#labelAccount11");
        if (account!=null) account.setText(textAccount.getText());

        nameWmCover = (Label) bookletToPrint.lookup("#labelNameWM");
        if (nameWmCover!=null) nameWmCover.setText(textFieldWM.getText());

        adress = (Label) bookletToPrint.lookup("#labelAdress");
        if (adress!=null) adress.setText(textFieldAddress.getText());

        zipCity = (Label) bookletToPrint.lookup("#labelZipCity");
        if (zipCity!=null) zipCity.setText(textZipCity.getText());

        index = (Label) bookletToPrint.lookup("#labelIndex");
        if (index!=null) index.setText(textIndex);

    }


}
