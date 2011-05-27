package model;

public class ChaveCarrinho {

    int sequencia;
    String codigobarra;
    int quantidade;

    public ChaveCarrinho(int sequencia, String codigobarra, int quantidade) {
        this.sequencia = sequencia;
        this.codigobarra = codigobarra;
        this.quantidade = quantidade;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
    
}
