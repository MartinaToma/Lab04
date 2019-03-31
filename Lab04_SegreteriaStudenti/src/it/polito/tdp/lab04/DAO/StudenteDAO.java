package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.polito.tdp.lab04.model.Studente;
public class StudenteDAO {

	public  Studente infoNome(int matricolaRicevuta) {
		
		 String sql2= "SELECT * FROM studente WHERE matricola=?";
		
		Studente stu=null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql2);
			st.setInt(1, matricolaRicevuta );
			ResultSet rs = st.executeQuery();			
						
			while(rs.next()) {
			stu=new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
			
			}
			conn.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
		return stu;
	}
}
