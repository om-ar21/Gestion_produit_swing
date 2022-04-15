package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connexion.DBConnexion;

public class clientController {
	String query;
	Connection cn=  new DBConnexion().connect();
	
	//inserer des clients

	public void insertClient(String nom, String prenom, String tel) throws SQLException
	{
		/*Instanciation d'un objet statement*/

		Statement stmt= cn.createStatement();

		try{
			query="INSERT INTO client(nom,prenom,tel) " + "VALUES ('"+nom+"','"+prenom+"','"+tel+"')";
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
	
	//update des clients
	
	public void updateClient(int idClient, String nom, String prenom, String tel) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "update client set nom='"+nom+"', prenom='"+prenom+"', tel='"+tel+"' where idClient = '" + idClient + "'";

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
	
	//supprimer des clients
	
	public void deleteClient(int idClient) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "delete from client where idClient = '" + idClient + "'";

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
	
	//afficher des clients
	
	public ResultSet seeClient() throws SQLException
	{
		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{
			query = "SELECT * FROM client";
			rs = stmt.executeQuery(query);



		}catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}

}
