package Model;

public class ClientModel {
	
	private int IdClient;
	private String nom;
	private String prenom;
	private String tel;

	public int getIdClient() {
		return IdClient;
	}

	public void setIdClient(int idClient) {
		IdClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public ClientModel (int IDcl, String nm, String prnm, String tl)
	{
		/*param�tre courant */
		this.IdClient = IDcl;
		this.nom = nm;
		this.prenom = prnm;
		this.tel = tl;
	}

	
}
