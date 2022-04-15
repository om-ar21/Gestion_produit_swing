package Model;

public class ProduitModel {
	
	private int idProduit;
	private String nom;
	private int prix;
	private int idCategorie;
	
	public ProduitModel (int idProd, String nm, int prx, int idCat)
	{
		/*param�tre courant */
		this.idProduit = idProd;
		this.nom = nm;
		this.prix = prx;
		this.idCategorie= idCat;
	}
	
	

	public int getIdproduit() {
		return idProduit;
	}
	public void setIdproduit(int iDproduit) {
		idProduit = iDproduit;
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nm) {
		nom = nm;
	}
	

	public int getPrix() {
		return prix;
	}
	public void setIdcommande(int prx) {
		prix = prx;
	}

	

	public int getIdcategorie() {
		return idCategorie;
	}
	public void setIdcategorie(int iDcat) {
		idCategorie = iDcat;
	}
}
