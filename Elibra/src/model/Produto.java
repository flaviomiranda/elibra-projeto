package model;
import java.util.Date;

public class Produto {

	double CD_PROD;
	double CD_CAT;
        double CD_MARCA;
	String CD_BARRA_PROD;
	String NM_PROD;
	double QTD_PROD; 
	double VL_PROD ;
	Date DT_VAL_PROD;
	
	public Produto(double cd_prod, double cd_cat, double cd_marca, String cd_barra_prod, String nm_prod, double qtd_prod, double vl_prod, Date dt_val_prod) {
		super();
		CD_PROD = cd_prod;
                CD_CAT = cd_cat;
		CD_MARCA = cd_marca;
		CD_BARRA_PROD = cd_barra_prod;
		NM_PROD = nm_prod;
		QTD_PROD = qtd_prod;
		VL_PROD = vl_prod;
		DT_VAL_PROD = dt_val_prod;
	}

	public String getCD_BARRA_PROD() {
		return CD_BARRA_PROD;
	}

	public void setCD_BARRA_PROD(String cd_barra_prod) {
		CD_BARRA_PROD = cd_barra_prod;
	}

	public double getCD_MARCA() {
		return CD_MARCA;
	}

	public void setCD_MARCA(double cd_marca) {
		CD_MARCA = cd_marca;
	}

        public double getCD_CAT() {
            return CD_CAT;
        }

        public void setCD_CAT(double CD_CAT) {
            this.CD_CAT = CD_CAT;
        }

	public double getCD_PROD() {
		return CD_PROD;
	}

	public void setCD_PROD(double cd_prod) {
		CD_PROD = cd_prod;
	}

	public Date getDT_VAL_PROD() {
		return DT_VAL_PROD;
	}

	public void setDT_VAL_PROD(Date dt_val_prod) {
		DT_VAL_PROD = dt_val_prod;
	}

	public String getNM_PROD() {
		return NM_PROD;
	}

	public void setNM_PROD(String nm_prod) {
		NM_PROD = nm_prod;
	}

	public double getQTD_PROD() {
		return QTD_PROD;
	}

	public void setQTD_PROD(double qtd_prod) {
		QTD_PROD = qtd_prod;
	}

	public double getVL_PROD() {
		return VL_PROD;
	}

	public void setVL_PROD(double vl_prod) {
		VL_PROD = vl_prod;
	}
	
}
