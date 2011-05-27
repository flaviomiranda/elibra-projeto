package model;

public class ClienteCategoria {

	double CD_CAT;
	double CD_CLI;
	
	public ClienteCategoria(double cd_cat, double cd_cli) {
		super();
		CD_CAT = cd_cat;
		CD_CLI = cd_cli;
	}

	public double getCD_CAT() {
		return CD_CAT;
	}

	public void setCD_CAT(double cd_cat) {
		CD_CAT = cd_cat;
	}

	public double getCD_CLI() {
		return CD_CLI;
	}

	public void setCD_CLI(double cd_cli) {
		CD_CLI = cd_cli;
	}
	
}
