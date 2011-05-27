package model;

public class Funcionario {

	double CD_FUNC;
	String NM_FUNC;
	double CD_ACESSO;
	
	public Funcionario(double cd_func, String nm_func, double cd_acesso) {
		super();
		CD_FUNC = cd_func;
		NM_FUNC = nm_func;
		CD_ACESSO = cd_acesso;
	}

	public double getCD_ACESSO() {
		return CD_ACESSO;
	}

	public void setCD_ACESSO(double cd_acesso) {
		CD_ACESSO = cd_acesso;
	}

	public double getCD_FUNC() {
		return CD_FUNC;
	}

	public void setCD_FUNC(double cd_func) {
		CD_FUNC = cd_func;
	}

	public String getNM_FUNC() {
		return NM_FUNC;
	}

	public void setNM_FUNC(String nm_func) {
		NM_FUNC = nm_func;
	}

}