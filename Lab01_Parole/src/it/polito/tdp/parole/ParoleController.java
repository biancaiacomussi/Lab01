package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtTempo;
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private Button bttCancella;

    @FXML
    void doCancella(ActionEvent event) {
    	double start = System.nanoTime();
    	txtResult.clear();
    	String p = txtParola.getText();
    	if(!p.matches("[a-zA-Z]+")) {
			txtResult.appendText("Devi inserire una parola\n");
			throw new InvalidParameterException("Devi inserire una parola\n");
		}
    	
    	if(elenco.presente(p)==true) {
    	elenco.cancellaParola(p);
    	txtResult.appendText("Le parole inserite sono:\n");
    	txtResult.appendText(elenco.elencoAlfabetico());
    	}
    	else {
    		txtResult.appendText("Impossibile cancellare parola non presente\n");
    	}
    	double end = System.nanoTime();
    	txtTempo.appendText("Tempo di esecuzione: "+((end-start)/1000000000)+"\n");
    }


    @FXML
    void doInsert(ActionEvent event) {
    	double start = System.nanoTime();
    	txtResult.clear();
    	String p = txtParola.getText();
    	if(!p.matches("[a-zA-Z]+")) {
			txtResult.appendText("Devi inserire una parola\n");
			throw new InvalidParameterException("Devi inserire una parola\n");
		}
    	
    	if(!elenco.presente(p))
    	elenco.addParola(p);
    	txtResult.appendText("Le parole inserite sono:\n");
    	txtResult.appendText(elenco.elencoAlfabetico());
    	
    	txtParola.clear();
    	double end = System.nanoTime();
    	txtTempo.appendText("Tempo di esecuzione: "+((end-start)/1000000000)+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	txtTempo.clear();
    	//txtTempo.appendText("Tempo di esecuzione: "+System.nanoTime()+"\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
