package Model;

public class LDCModel {

	private int idLc;
	private int idProduit;
	private int idCommande;
	
	public LDCModel (int IDLc, int iDProduit, int IdCommande)
	{
		/*param�tre courant */
		this.idLc = IDLc;
		this.idProduit = iDProduit;
		this.idCommande = IdCommande;
	}
	public int getIdlc() {
		return idLc;
	}
	public void setIdlc(int iDlc) {
		idLc = iDlc;
	}
	
	public int getIdproduit() {
		return idProduit;
	}
	public void setIdProduit(int iDprod) {
		idProduit = iDprod;
	}
	
	public int getIdcommande() {
		return idCommande;
	}
	public void setIdcommande(int iDcmd) {
		idCommande = iDcmd;
	}
	

}
