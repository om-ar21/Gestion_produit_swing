package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connexion.DBConnexion;

public class EmployeController {
	String query;
	Connection cn=  new DBConnexion().connect();
	
	//inserer des employes

	public void insertEmploye(String nom, String prenom) throws SQLException
	{
		/*Instanciation d'un objet statement*/

		Statement stmt= cn.createStatement();

		try{
			query="INSERT INTO employe(nom,prenom) " + "VALUES ('"+nom+"','"+prenom+"')";
			int newrow=stmt.executeUpdate(query);
			System.out.println(newrow);
			if(newrow>0)
			{
				JOptionPane.showMessageDialog(null, this,"Informations inseres.", newrow);
			}



		}catch(Exception e)
		{
			System.out.println(e);
		}
		stmt.close();
	}
	
	//update des employes
	
	public void updateEmploye(int idEmploye, String nom, String prenom) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "update employe set nom='"+nom+"', prenom='"+prenom+"' where idEmploye = '" + idEmploye + "'";

			int row=stmt.executeUpdate(query);

			if(row>0)
			{
				System.out.println("Modification validee");
			}



		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//supprimer des employes
	
	public void deleteEmploye(int idEmploye) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "delete from employe where idEmploye = '" + idEmploye + "'";

			int row=stmt.executeUpdate(query);

			System.out.println(row);

			if(row>0)
			{
				System.out.println("Suppression validee");
			}



		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//afficher des employes
	
	public ResultSet seeEmploye() throws SQLException
	{
		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{
			query = "SELECT * FROM employe";
			rs = stmt.executeQuery(query);



		}catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}



}
