package model;

public class LoteProduto {

	double CD_PROD; 
	double CD_LOTE;
	double QTD_PROD;
	
	public LoteProduto(double cd_prod, double cd_lote, double qtd_prod) {
		super();
		CD_PROD = cd_prod;
		CD_LOTE = cd_lote;
		QTD_PROD = qtd_prod;
	}

	public double getCD_LOTE() {
		return CD_LOTE;
	}

	public void setCD_LOTE(double cd_lote) {
		CD_LOTE = cd_lote;
	}

	public double getCD_PROD() {
		return CD_PROD;
	}

	public void setCD_PROD(double cd_prod) {
		CD_PROD = cd_prod;
	}

	public double getQTD_PROD() {
		return QTD_PROD;
	}

	public void setQTD_PROD(double qtd_prod) {
		QTD_PROD = qtd_prod;
	}	
}
