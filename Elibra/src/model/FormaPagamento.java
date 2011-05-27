package model;
                                                           
public class FormaPagamento {                                   

	double CD_FORM_PGMTO;                                         
String NM_FORM_PGMTO;                                      
                                                           
public FormaPagamento(double cd_form_pgmto, String nm_form_pgmto) {
	super();                                                 
	CD_FORM_PGMTO = cd_form_pgmto;                           
	NM_FORM_PGMTO = nm_form_pgmto;                           
}                                                          
                                                           
public double getCD_FORM_PGMTO() {                            
	return CD_FORM_PGMTO;                                    
}                                                          
                                                           
public void setCD_FORM_PGMTO(double cd_form_pgmto) {          
	CD_FORM_PGMTO = cd_form_pgmto;                           
}                                                          
                                                           
public String getNM_FORM_PGMTO() {                         
	return NM_FORM_PGMTO;                                    
}                                                          
                                                           
public void setNM_FORM_PGMTO(String nm_form_pgmto) {       
	NM_FORM_PGMTO = nm_form_pgmto;                           
}                                                          
                                                           
}                                                          