package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connexion.DBConnexion;

public class CommandeController {
	String query;
	Connection cn=  new DBConnexion().connect();
	
	//inserer des commandes

	public void insertCommande(int quantite , int montantTotal, int idEmploye) throws SQLException
	{
		/*Instanciation d'un objet statement*/

		Statement stmt= cn.createStatement();

		try{
			
			query="INSERT INTO commande(quantite,montantTotal,idEmploye) " + "VALUES ('"+quantite+"','"+montantTotal+"','"+idEmploye+"')";
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
	
	//update des commandes
	
	public void updateCommande(int idCommande, int quantite, int montantTotal, int idEmploye) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "update commande set quantite='"+quantite+"', montantTotal='"+montantTotal+"', idEmploye='"+idEmploye+"' where idCommande = '" + idCommande + "'";

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
	
	//supprimer des commandes
	
	public void deleteCommande(int idCommande) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "delete from commande where idCommande = '" + idCommande+ "'";

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
	
	//afficher des commandes
	
	public ResultSet seeCommande() throws SQLException
	{
		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{
			query = "SELECT * FROM commande";
			rs = stmt.executeQuery(query);



		}catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}


}
