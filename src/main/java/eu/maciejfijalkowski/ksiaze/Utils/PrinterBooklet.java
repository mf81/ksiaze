package eu.maciejfijalkowski.ksiaze.Utils;

import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrinterBooklet {

    public Node fxmlPrintingSchemaLoader(String fileName) throws IOException {
        return FXMLLoader.load(getClass().getClassLoader().getResource(fileName));
    }

    public void start(Node fxmlCover, Node fxmlSchema, Boolean coverLoader, int numberOfPages){
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, 100,0,0,0);

        boolean success = false;
        PrinterJob job = PrinterJob.createPrinterJob(printer);
        job.getJobSettings().setPageLayout(pageLayout);
        job.getJobSettings().setJobName("Książe - wydruk");

        if (job != null && job.showPrintDialog(null)){

            if (coverLoader) success = job.printPage(fxmlCover);

            if (numberOfPages != 0)
                for (int i = 0; i < numberOfPages; i++)
                    success = job.printPage(fxmlSchema);

            if (success) {
                job.endJob();
            }
        }
    }
}
