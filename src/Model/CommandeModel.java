package Model;

public class CommandeModel {

	private int idCommande;
	private int quantite;
	private int montantTotal;
	private int idClient;
	

	public CommandeModel (int IDcom, int quant, int montTotal, int idClient)
	{
		/*param�tre courant */
		this.idCommande = IDcom;
		this.quantite = quant;
		this.montantTotal = montTotal;
		this.idClient=idClient;
	}

	//getters and setters

	public int getIDCommande() {
		return idCommande;
	}
	public void setIdCommande(int iDCommande) {
		idCommande = iDCommande;
	}


	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quanti) {
		quantite = quanti;
	}
	
	public int getMontantT() {
		return montantTotal;
	}
	public void setMontantT(int montT) {
		montantTotal = montT;
	}
	
	public int getidClient() {
	return idClient;
}
public void setidEmp(int idemp) {
	idClient = idemp;
}

}
