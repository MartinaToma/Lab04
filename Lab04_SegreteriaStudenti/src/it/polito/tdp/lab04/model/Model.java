package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO corsi;
	private StudenteDAO student;
	
	public Model() {
		 corsi=new CorsoDAO();
		 student=new StudenteDAO();
	}

	public List<Corso> dimmiLista() {
		
		List <Corso> tuttiCorsi=corsi.getTuttiICorsi();
		
		return tuttiCorsi;
	}
	
	public Studente dimmiNome(int matricola){	 
		
		
	  return student.infoNome(matricola);		
	}
	
	public List<Studente> elencoIscritti(Corso corso ){		
		
		return corsi.getStudentiIscrittiAlCorso(corso);
		
	}

	
	public List<Corso> getCorsiMatricola(int matricola) {
		
		
		return corsi.getCorsiMatricola(matricola);
		
	}

	public void IscriviStudente(int a, String corso) {
		
		
		
		
		//Corso c=cor.infoCorso(corso);
		
		//c.inscriviStudenteACorso(student, c);
	}
	
}
