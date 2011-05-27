package model;

public class Login {

	String LOGIN;
	double CD_FUNC;
	String SENHA;
	
	public Login(String login, double cd_func, String senha) {
		super();
		LOGIN = login;
		CD_FUNC = cd_func;
		SENHA = senha;
	}

	public double getCD_FUNC() {
		return CD_FUNC;
	}

	public void setCD_FUNC(double cd_func) {
		CD_FUNC = cd_func;
	}

	public String getLOGIN() {
		return LOGIN;
	}

	public void setLOGIN(String login) {
		LOGIN = login;
	}

	public String getSENHA() {
		return SENHA;
	}

	public void setSENHA(String senha) {
		SENHA = senha;
	}

}
