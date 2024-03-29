package model;
import java.util.Date;

public class Venda {
	double CD_VENDA;
	double CD_FORM_PGMTO;
	double CD_FUNC; 
	double CD_CLI;
	double VL_DESC;
	String HR_VENDA;
        double QTD_PARCELA;
        Date DT_VENDA;
        double VL_VENDA;
	
	public Venda(double cd_venda, double cd_form_pgmto, double cd_func, double cd_cli, double vl_desc, String hr_venda, double qtd_parcela, Date dt_venda, double vl_venda) {
		super();
		CD_VENDA = cd_venda;
		CD_FORM_PGMTO = cd_form_pgmto;
		CD_FUNC = cd_func;
		CD_CLI = cd_cli;
		VL_DESC = vl_desc;
		HR_VENDA = hr_venda;
                QTD_PARCELA = qtd_parcela;
                DT_VENDA = dt_venda;
                VL_VENDA = vl_venda;
	}

	public double getCD_CLI() {
		return CD_CLI;
	}

	public void setCD_CLI(double cd_cli) {
		CD_CLI = cd_cli;
	}

	public double getCD_FORM_PGMTO() {
		return CD_FORM_PGMTO;
	}

	public void setCD_FORM_PGMTO(double cd_form_pgmto) {
		CD_FORM_PGMTO = cd_form_pgmto;
	}

	public double getCD_FUNC() {
		return CD_FUNC;
	}

	public void setCD_FUNC(double cd_func) {
		CD_FUNC = cd_func;
	}

	public double getCD_VENDA() {
		return CD_VENDA;
	}

	public void setCD_VENDA(double cd_venda) {
		CD_VENDA = cd_venda;
	}
	
        public double getVL_DESC() {
		return VL_DESC;
	}

	public void setVL_DESC(double vl_desc) {
		VL_DESC = vl_desc;
	}

	public String getHR_VENDA() {
		return HR_VENDA;
	}

	public void setHR_VENDA(String hr_venda) {
		HR_VENDA = hr_venda;
	}

        public double getQTD_PARCELA() {
            return QTD_PARCELA;
        }

        public void setQTD_PARCELA(double QTD_PARCELA) {
            this.QTD_PARCELA = QTD_PARCELA;
        }

    public Date getDT_VENDA() {
        return DT_VENDA;
    }

    public void setDT_VENDA(Date DT_VENDA) {
        this.DT_VENDA = DT_VENDA;
    }

    public double getVL_VENDA() {
        return VL_VENDA;
    }

    public void setVL_VENDA(double VL_VENDA) {
        this.VL_VENDA = VL_VENDA;
    }
        
}
