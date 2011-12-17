package model;

public class Marca {
	double CD_MARCA;
	//double CD_CAT;
	String NM_MARCA;
	
	public Marca(double cd_marca, String nm_marca) {
		super();
		CD_MARCA = cd_marca;
		//CD_CAT = cd_cat;
		NM_MARCA = nm_marca;
	}

//	public double getCD_CAT() {
//		return CD_CAT;
//	}
//
//	public void setCD_CAT(double cd_cat) {
//		CD_CAT = cd_cat;
//	}

	public double getCD_MARCA() {
		return CD_MARCA;
	}

	public void setCD_MARCA(double cd_marca) {
		CD_MARCA = cd_marca;
	}

	public String getNM_MARCA() {
		return NM_MARCA;
	}

	public void setNM_MARCA(String nm_marca) {
		NM_MARCA = nm_marca;
	}
	
}
