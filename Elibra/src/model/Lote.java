package model;
import java.sql.Date;

public class Lote {
	
	double CD_LOTE;
	double CD_FORN;
	Date DT_CHGDA;
	double VL_PAGO;
	
	public Lote(double cd_lote, double cd_forn, Date dt_chgda, double vl_pago) {
		super();
		CD_LOTE = cd_lote;
		CD_FORN = cd_forn;
		DT_CHGDA = dt_chgda;
		VL_PAGO = vl_pago;
	}

	public double getCD_FORN() {
		return CD_FORN;
	}

	public void setCD_FORN(double cd_forn) {
		CD_FORN = cd_forn;
	}

	public double getCD_LOTE() {
		return CD_LOTE;
	}

	public void setCD_LOTE(double cd_lote) {
		CD_LOTE = cd_lote;
	}

	public Date getDT_CHGDA() {
		return DT_CHGDA;
	}

	public void setDT_CHGDA(Date dt_chgda) {
		DT_CHGDA = dt_chgda;
	}

	public double getVL_PAGO() {
		return VL_PAGO;
	}

	public void setVL_PAGO(double vl_pago) {
		VL_PAGO = vl_pago;
	}

}
