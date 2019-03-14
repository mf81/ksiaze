package eu.maciejfijalkowski.ksiaze.Utils;

import eu.maciejfijalkowski.ksiaze.Model.Model;
import eu.maciejfijalkowski.ksiaze.Model.ModelDTO;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class FillBlankBooklet {

    private Label name;
    private Label account;
    private Label nameWmCover;
    private Label adress;
    private Label zipCity;
    private Label index;

    private Node bookletToPrint;

    public FillBlankBooklet() {
    }

    public FillBlankBooklet(Node bookletToPrint){
        this.bookletToPrint=bookletToPrint;
    }

    public void setBlankBooklet(Node bookletToPrint){
        this.bookletToPrint=bookletToPrint;
    }

    public void setUpBooklet(ModelDTO modelDTO){

        name = (Label) bookletToPrint.lookup("#labelName");
        if (name!=null) name.setText(modelDTO.getModel().getName());

        account = (Label) bookletToPrint.lookup("#labelAccount11");
        if (account!=null) account.setText(modelDTO.getModel().getAccount());

        nameWmCover = (Label) bookletToPrint.lookup("#labelNameWM");
        if (nameWmCover!=null) nameWmCover.setText(modelDTO.getModel().getNameWM());

        adress = (Label) bookletToPrint.lookup("#labelAdress");
        if (adress!=null) adress.setText(modelDTO.getModel().getAddress());

        zipCity = (Label) bookletToPrint.lookup("#labelZipCity");
        if (zipCity!=null) zipCity.setText(modelDTO.getModel().getZipCity());

        index = (Label) bookletToPrint.lookup("#labelIndex");
        if (index!=null) index.setText(modelDTO.getModel().getIndex());

    }


}
