package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connexion.DBConnexion;

public class CategoriesController {
	String query;
	Connection cn=  new DBConnexion().connect();
	
	//inserer des categories

	public void insertCategory(String nom) throws SQLException
	{
		/*Instanciation d'un objet statement*/

		Statement stmt= cn.createStatement();

		try{
			query="INSERT INTO `categories`(`nom`)" + "VALUES ('"+nom+"')";
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
	
	//update des categories
	
	public void updateCategory(int idCategorie, String nom) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "update categories set nom='"+nom+"' where idCategorie = '" + idCategorie + "'";

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
	
	//supprimer des categories
	
	public void deleteCategory(int idCategorie) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "delete from categories where idCategorie = '" + idCategorie + "'";

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
	
	//afficher des categories
	
	public ResultSet seeCategory() throws SQLException
	{
		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{
			query = "SELECT idCategorie, nom FROM categories";
			rs = stmt.executeQuery(query);



		}catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}




	
}


