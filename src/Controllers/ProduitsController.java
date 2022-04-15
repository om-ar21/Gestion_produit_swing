package Controllers;
import Connexion.DBConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProduitsController {

	String query;
	Connection cn=  new DBConnexion().connect();
	
	//inserer des categories

	public void insertProduit(String nom, int prix, int idCategorie) throws SQLException
	{
		/*Instanciation d'un objet statement*/

		Statement stmt= cn.createStatement();

		try{
			
			query="INSERT INTO produits(nom,prix,idCategorie) " + "VALUES ('"+nom+"','"+prix+"','"+idCategorie+"')";
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
	
	public void updateProduit(int idProduit, String nom, int prix, int idCategorie) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "update produits set nom='"+nom+"', prix='"+prix+"', idCategorie='"+idCategorie+"' where idProduit = '" + idProduit + "'";

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
	
	public void deleteProduit(int idProduit) throws SQLException {

		// TODO Auto-generated method stub

		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{

			String query = "delete from produits where idProduit = '" + idProduit+ "'";

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
	
	public ResultSet seeProduit() throws SQLException
	{
		Statement stmt= cn.createStatement();
		ResultSet rs= null;
		try{
			query = "SELECT * FROM produits";
			rs = stmt.executeQuery(query);



		}catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}


}

	