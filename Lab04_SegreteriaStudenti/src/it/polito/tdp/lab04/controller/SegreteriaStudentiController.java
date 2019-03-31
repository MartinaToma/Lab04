package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	List<Corso> lista;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboID;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextArea txtArea;
    
    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void chooseCorso(ActionEvent event) {
    	

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	try {
    		 Integer.parseInt(txtMatricola.getText());
    	}
    	catch(Exception e) {
    		txtArea.appendText("Matricola non ammessa");
    		
    	}
    	List<Corso> elencoCorsi=model.getCorsiMatricola(Integer.parseInt(txtMatricola.getText()));
    	if(elencoCorsi==null) {
    		txtArea.appendText("Matricola non esistente");
    		return;
    	}
    	
    	
    	StringBuilder sb = new StringBuilder();

		for (Corso corso : elencoCorsi) {
			
			sb.append(String.format("%-8s ", corso.getCodIns()));
			sb.append(String.format("%-4s ", corso.getCrediti()));
			sb.append(String.format("%-45s ", corso.getNome()));
			sb.append(String.format("%-4s ", corso.getPd()));
			sb.append("\n");
						
		}		
		txtArea.appendText(sb.toString());
    	

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	if(comboID.getValue()==null) {
    		txtArea.appendText("ERRORE:non ci sono corsi");
    		return;
    	}
    	
    	List<Studente> nominativi=model.elencoIscritti(comboID.getValue()); 	
    	
    	try {
   		 Integer.parseInt(txtMatricola.getText());
   		 boolean flag=false;
   		for(Studente s:nominativi) {
			if(s.getMatricola()==Integer.parseInt(txtMatricola.getText()))
			{
				txtArea.appendText("Studente iscritto al corso");
				flag=true;
				break;
				
			}
			
		}
		if(flag==false){
			txtArea.appendText("Studente non iscritto al corso");
		}
   	    }
       	catch(Exception e) {
       	
       		StringBuilder sb = new StringBuilder();

			for (Studente studente : nominativi) {

				sb.append(String.format("%-10s ", studente.getMatricola()));
				sb.append(String.format("%-20s ", studente.getCognome()));
				sb.append(String.format("%-20s ", studente.getNome()));
				sb.append(String.format("%-10s ", studente.getCDS()));
				sb.append("\n");
			}

			txtArea.appendText(sb.toString());
       		
   		
   	}    	
    
    	}
    	 

    @FXML
    void doCheck(ActionEvent event) {
    	try {
   		 Integer.parseInt(txtMatricola.getText());
   	}
   	catch(Exception e) {
   		txtArea.appendText("Matricola non ammessa");
   		return;
   		
   	}
    	
    	int matricola=Integer.parseInt(txtMatricola.getText());
    	
    	Studente st=model.dimmiNome(matricola);
    	if(st==null) {
    		txtArea.appendText("Errore matricola non esistente");
    		return;
    	}
    	txtNome.appendText(st.getNome());
    	txtCognome.appendText(st.getCognome());

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	 	
    	
    	List<Studente> nominativi=model.elencoIscritti(comboID.getValue());   	
    	
    	
    		boolean flag=false;
    		int a;
    		for(Studente s:nominativi) {
    			a=Integer.parseInt(txtMatricola.getText());
    			if(s.getMatricola()==a)
    			{
    				
    				flag=true;
    				break;
    				
    			}
    			
    		}
    		if(flag==false) {
    			//model.IscriviStudente(Integer.parseInt(txtMatricola.getText()),comboID.getValue());
    		}   	
    	
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtArea.clear();
    	comboID.getSelectionModel().clearSelection();

    	

    }

    @FXML
    void initialize() {
        assert comboID != null : "fx:id=\"comboID\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }

	public void setModel(Model model) {
		
		this.model=model;
		lista=new LinkedList<Corso>();
		lista=model.dimmiLista();
		for(Corso s:lista)
		comboID.getItems().add(s);
	}
}
