package model;

public class Motivo {
	double CD_MOTIVO;
	String DS_MOTIVO;
	
	public Motivo(double cd_motivo, String ds_motivo) {
		super();
		CD_MOTIVO = cd_motivo;
		DS_MOTIVO = ds_motivo;
	}

	public double getCD_MOTIVO() {
		return CD_MOTIVO;
	}

	public void setCD_MOTIVO(double cd_motivo) {
		CD_MOTIVO = cd_motivo;
	}

	public String getDS_MOTIVO() {
		return DS_MOTIVO;
	}

	public void setDS_MOTIVO(String ds_motivo) {
		DS_MOTIVO = ds_motivo;
	}
	
}
