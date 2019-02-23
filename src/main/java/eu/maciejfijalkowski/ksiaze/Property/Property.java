package eu.maciejfijalkowski.ksiaze.Property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Property {

    private StringProperty labelProperty;

    public final String getLabel() {
        if(labelProperty != null)
            return labelProperty.get();
        else
            return null;
    }

    public final void setLabel(String label) {
        this.labelTextProperty().set(label);
    }

    public StringProperty labelTextProperty(){
        if(labelProperty == null)
            labelProperty = new SimpleStringProperty("");
        return labelProperty;
    }
}