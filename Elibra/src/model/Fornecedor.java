package model;

public class Fornecedor {

	double CD_FORN;
	String NM_RZAO_FORN;
	double  CNPJ_FORN;
	double  CFILIAL_FORN;
	double  CTRL_CNPJ_FORN;
	String END_FORN;
	String BAIRRO_FORN;
	String CIDADE_FORN;
	String UF_FORN;
	double DDD_TEL_FORN;
	double TEL_FORN;
	double DDD_FAX_FORN;
	double FAX_FORN;
	String EMAIL_FORN;
	String NM_RESP_FORN;
	String OBS_FORN;
	
	
	
	public Fornecedor(double cd_forn, String nm_rzao_forn, double cnpj_forn, double cfilial_forn, double ctrl_cnpj_forn, String end_forn, String bairro_forn, String cidade_forn, String uf_forn, double ddd_tel_forn, double tel_forn, double ddd_fax_forn, double fax_forn, String email_forn, String nm_resp_forn, String obs_forn) {
		super();
		CD_FORN = cd_forn;
		NM_RZAO_FORN = nm_rzao_forn;
		CNPJ_FORN = cnpj_forn;
		CFILIAL_FORN = cfilial_forn;
		CTRL_CNPJ_FORN = ctrl_cnpj_forn;
		END_FORN = end_forn;
		BAIRRO_FORN = bairro_forn;
		CIDADE_FORN = cidade_forn;
		UF_FORN = uf_forn;
		DDD_TEL_FORN = ddd_tel_forn;
		TEL_FORN = tel_forn;
		DDD_FAX_FORN = ddd_fax_forn;
		FAX_FORN = fax_forn;
		EMAIL_FORN = email_forn;
		NM_RESP_FORN = nm_resp_forn;
		OBS_FORN = obs_forn;
	}
	public String getBAIRRO_FORN() {
		return BAIRRO_FORN;
	}
	public void setBAIRRO_FORN(String bairro_forn) {
		BAIRRO_FORN = bairro_forn;
	}
	public double getCD_FORN() {
		return CD_FORN;
	}
	public void setCD_FORN(double cd_forn) {
		CD_FORN = cd_forn;
	}
	public double getCFILIAL_FORN() {
		return CFILIAL_FORN;
	}
	public void setCFILIAL_FORN(double cfilial_forn) {
		CFILIAL_FORN = cfilial_forn;
	}
	public String getCIDADE_FORN() {
		return CIDADE_FORN;
	}
	public void setCIDADE_FORN(String cidade_forn) {
		CIDADE_FORN = cidade_forn;
	}
	public double getCNPJ_FORN() {
		return CNPJ_FORN;
	}
	public void setCNPJ_FORN(double cnpj_forn) {
		CNPJ_FORN = cnpj_forn;
	}
	public double getCTRL_CNPJ_FORN() {
		return CTRL_CNPJ_FORN;
	}
	public void setCTRL_CNPJ_FORN(double ctrl_cnpj_forn) {
		CTRL_CNPJ_FORN = ctrl_cnpj_forn;
	}
	public double getDDD_FAX_FORN() {
		return DDD_FAX_FORN;
	}
	public void setDDD_FAX_FORN(double ddd_fax_forn) {
		DDD_FAX_FORN = ddd_fax_forn;
	}
	public double getDDD_TEL_FORN() {
		return DDD_TEL_FORN;
	}
	public void setDDD_TEL_FORN(double ddd_tel_forn) {
		DDD_TEL_FORN = ddd_tel_forn;
	}
	public String getEMAIL_FORN() {
		return EMAIL_FORN;
	}
	public void setEMAIL_FORN(String email_forn) {
		EMAIL_FORN = email_forn;
	}
	public String getEND_FORN() {
		return END_FORN;
	}
	public void setEND_FORN(String end_forn) {
		END_FORN = end_forn;
	}
	public double getFAX_FORN() {
		return FAX_FORN;
	}
	public void setFAX_FORN(double fax_forn) {
		FAX_FORN = fax_forn;
	}
	public String getNM_RESP_FORN() {
		return NM_RESP_FORN;
	}
	public void setNM_RESP_FORN(String nm_resp_forn) {
		NM_RESP_FORN = nm_resp_forn;
	}
	public String getNM_RZAO_FORN() {
		return NM_RZAO_FORN;
	}
	public void setNM_RZAO_FORN(String nm_rzao_forn) {
		NM_RZAO_FORN = nm_rzao_forn;
	}
	public String getOBS_FORN() {
		return OBS_FORN;
	}
	public void setOBS_FORN(String obs_forn) {
		OBS_FORN = obs_forn;
	}
	public double getTEL_FORN() {
		return TEL_FORN;
	}
	public void setTEL_FORN(double tel_forn) {
		TEL_FORN = tel_forn;
	}
	public String getUF_FORN() {
		return UF_FORN;
	}
	public void setUF_FORN(String uf_forn) {
		UF_FORN = uf_forn;
	}
	
}
