package model;

public class Motivo {
	int CD_MOTIVO;
	String DS_MOTIVO;
	
	public Motivo(int cd_motivo, String ds_motivo) {
		super();
		CD_MOTIVO = cd_motivo;
		DS_MOTIVO = ds_motivo;
	}

	public int getCD_MOTIVO() {
		return CD_MOTIVO;
	}

	public void setCD_MOTIVO(int cd_motivo) {
		CD_MOTIVO = cd_motivo;
	}

	public String getDS_MOTIVO() {
		return DS_MOTIVO;
	}

	public void setDS_MOTIVO(String ds_motivo) {
		DS_MOTIVO = ds_motivo;
	}
	
}
