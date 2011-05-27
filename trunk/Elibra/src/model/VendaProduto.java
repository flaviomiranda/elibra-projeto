package model;

public class VendaProduto {
	double CD_VENDA;
	double NSEQ_VENDA_PROD;
        double CD_PROD;
        double QTD_PROD;
        double VL_UNIT_PROD;
	
	public VendaProduto(double cd_venda, double nseq_venda_prod, double cd_prod, double qtd_prod, double vl_unit_prod) {
		super();
		CD_VENDA = cd_venda;
		NSEQ_VENDA_PROD = nseq_venda_prod;
		CD_PROD  = cd_prod;
		QTD_PROD = qtd_prod;
		VL_UNIT_PROD = vl_unit_prod;
	}

	public double getCD_VENDA() {
		return CD_VENDA;
	}

	public void setCD_VENDA(double cd_venda) {
		CD_VENDA = cd_venda;
	}
	
        public double getNSEQ_VENDA_PROD() {
		return NSEQ_VENDA_PROD;
	}

	public void setNSEQ_VENDA_PROD(double nseq_venda_prod) {
		NSEQ_VENDA_PROD = nseq_venda_prod;
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
	
	public double getVL_UNIT_PROD() {
		return VL_UNIT_PROD;
	}

	public void setVL_UNIT_PROD(double vl_unit_prod) {
		VL_UNIT_PROD = vl_unit_prod;
	}			

}