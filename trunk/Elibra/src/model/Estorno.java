package model;

public class Estorno {

	double NSEQ_ESTNO;
	double CD_MOTIVO;
	double CD_PROD;
	double CD_FUNC;
	String HR_EST;
	double VL_UNIT_PROD; 
	String DS_MOTVO_ESTNO;
        String DT_EST;
	
	public Estorno(double nseq_estno, double cd_motivo, double cd_prod, double cd_func, String hr_est, double vl_unit_prod, String ds_motvo_estno, String dt_est) {
		super();
		NSEQ_ESTNO = nseq_estno;
		CD_MOTIVO = cd_motivo;
		CD_PROD = cd_prod;
		CD_FUNC = cd_func;
		HR_EST = hr_est;
		VL_UNIT_PROD = vl_unit_prod;
		DS_MOTVO_ESTNO = ds_motvo_estno;
                DT_EST = dt_est;
	}

	public double getCD_FUNC() {
		return CD_FUNC;
	}

	public void setCD_FUNC(double cd_func) {
		CD_FUNC = cd_func;
	}

	public double getCD_MOTIVO() {
		return CD_MOTIVO;
	}

	public void setCD_MOTIVO(double cd_motivo) {
		CD_MOTIVO = cd_motivo;
	}

	public double getCD_PROD() {
		return CD_PROD;
	}

	public void setCD_PROD(double cd_prod) {
		CD_PROD = cd_prod;
	}

	public String getDS_MOTVO_ESTNO() {
		return DS_MOTVO_ESTNO;
	}

	public void setDS_MOTVO_ESTNO(String ds_motvo_estno) {
		DS_MOTVO_ESTNO = ds_motvo_estno;
	}

	public String getHR_EST() {
		return HR_EST;
	}

	public void setHR_EST(String hr_est) {
		HR_EST = hr_est;
	}

	public double getNSEQ_ESTNO() {
		return NSEQ_ESTNO;
	}

	public void setNSEQ_ESTNO(double nseq_estno) {
		NSEQ_ESTNO = nseq_estno;
	}

	public double getVL_UNIT_PROD() {
		return VL_UNIT_PROD;
	}

	public void setVL_UNIT_PROD(double vl_unit_prod) {
		VL_UNIT_PROD = vl_unit_prod;
	}

        public String getDT_EST() {
            return DT_EST;
        }

        public void setDT_EST(String DT_EST) {
            this.DT_EST = DT_EST;
        }
}
