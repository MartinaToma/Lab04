package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

		
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);				
				corsi.add(c);

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return corsi;
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		
		

		
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		
		final String sql= "SELECT studente.matricola, studente.cognome, studente.nome, studente.CDS FROM studente, iscrizione WHERE studente.matricola=iscrizione.matricola and iscrizione.codins=?";
		List<Studente> listaStudenti=new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,corso.getCodIns()  );
			ResultSet rs = st.executeQuery();
			
			//System.out.println(rs.getString("nome"));			
			while(rs.next()) {
			Studente stu=new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
			
		    listaStudenti.add(stu);
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaStudenti;
		
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		
		
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	

	public List<Corso> getCorsiMatricola(int matricola) {
		
		
		final String sql = "SELECT corso.codins,corso.crediti,corso.nome, corso.pd FROM corso,iscrizione WHERE corso.codins=iscrizione.codins and iscrizione.matricola=?";

		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

		
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);				
				corsi.add(c);

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return corsi;
	}
	
	
}
