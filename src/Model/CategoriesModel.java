package Model;

public class CategoriesModel {
	//attributs d'acces
	private int IdCategorie;
	private String nom;


	public CategoriesModel (int IDc, String nm)
	{
		/*param�tre courant */
		this.IdCategorie = IDc;
		this.nom = nm;
	}

	//getters and setters

	public int getIDCategorie() {
		return IdCategorie;
	}
	public void setIdCategorie(int iDCategorie) {
		IdCategorie = iDCategorie;
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String name) {
		nom = name;
	}



}
