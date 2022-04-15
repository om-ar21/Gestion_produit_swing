package Model;

public class EmployeModel {
	private int IdClient;
	private String nom;
	private String prenom;

	public int getIdClient() {
		return IdClient;
		
	}

	public void setIdClient(int idClient) {
		IdClient = idClient;
	}

	public EmployeModel(int idClient, String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		this.IdClient = idClient;
	}

}
