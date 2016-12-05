package projetotroco;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.rmi.CORBA.Util;

public class Caixa {

    private BigDecimal valor;
    private Integer qtde;

    public Caixa(BigDecimal valor, Integer qtde) {
        this.valor = valor;
        this.qtde = qtde;
    }

    
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }
}