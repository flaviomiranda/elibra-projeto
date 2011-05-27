package model;

public class Categoria {

	double CD_CAT;
	String DS_CAT;
	
	public Categoria(double cd_cat, String ds_cat) {
		super();
		CD_CAT = cd_cat;
		DS_CAT = ds_cat;
	}

	public double getCD_CAT() {
		return CD_CAT;
	}

	public void setCD_CAT(double cd_cat) {
		CD_CAT = cd_cat;
	}

	public String getDS_CAT() {
		return DS_CAT;
	}

	public void setDS_CAT(String ds_cat) {
		DS_CAT = ds_cat;
	}
}
