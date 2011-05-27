package model;
import java.sql.Date;


public class Cliente {

	double CD_CLI;
	String NM_CLI;
	Date DT_NASC_CLI;
	String END_CLI;
	double DDD_TEL_CLI;
	double TEL_CLI;
	double DDD_CEL_CLI;
	double CEL_CLI ;
	String EMAIL_CLI;
	
	public Cliente(double cd_cli, String nm_cli, Date dt_nasc_cli, String end_cli, double ddd_tel_cli, double tel_cli, double ddd_cel_cli, double cel_cli, String email_cli) {
		super();
		CD_CLI = cd_cli;
		NM_CLI = nm_cli;
		DT_NASC_CLI = dt_nasc_cli;
		END_CLI = end_cli;
		DDD_TEL_CLI = ddd_tel_cli;
		TEL_CLI = tel_cli;
		DDD_CEL_CLI = ddd_cel_cli;
		CEL_CLI = cel_cli;
		EMAIL_CLI = email_cli;
	}

	public double getCD_CLI() {
		return CD_CLI;
	}

	public void setCD_CLI(double cd_cli) {
		CD_CLI = cd_cli;
	}

	public double getCEL_CLI() {
		return CEL_CLI;
	}

	public void setCEL_CLI(double cel_cli) {
		CEL_CLI = cel_cli;
	}

	public double getDDD_CEL_CLI() {
		return DDD_CEL_CLI;
	}

	public void setDDD_CEL_CLI(double ddd_cel_cli) {
		DDD_CEL_CLI = ddd_cel_cli;
	}

	public double getDDD_TEL_CLI() {
		return DDD_TEL_CLI;
	}

	public void setDDD_TEL_CLI(double ddd_tel_cli) {
		DDD_TEL_CLI = ddd_tel_cli;
	}

	public Date getDT_NASC_CLI() {
		return DT_NASC_CLI;
	}

	public void setDT_NASC_CLI(Date dt_nasc_cli) {
		DT_NASC_CLI = dt_nasc_cli;
	}

	public String getEMAIL_CLI() {
		return EMAIL_CLI;
	}

	public void setEMAIL_CLI(String email_cli) {
		EMAIL_CLI = email_cli;
	}

	public String getEND_CLI() {
		return END_CLI;
	}

	public void setEND_CLI(String end_cli) {
		END_CLI = end_cli;
	}

	public String getNM_CLI() {
		return NM_CLI;
	}

	public void setNM_CLI(String nm_cli) {
		NM_CLI = nm_cli;
	}

	public double getTEL_CLI() {
		return TEL_CLI;
	}

	public void setTEL_CLI(double tel_cli) {
		TEL_CLI = tel_cli;
	}
}
