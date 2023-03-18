package br.com.testesUnitarios.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo){
        if (saldo == null){
            throw new IllegalArgumentException();
        }
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor){
        if(valor == null || valor.signum() <= 0){
            throw new IllegalArgumentException();
        }
        if(this.saldo.compareTo(valor) < 0){
            throw new RuntimeException();
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor){
        if(valor == null || valor.signum() < 0){
            throw new IllegalArgumentException();
        }
        this.saldo.add(valor);
    }

    public BigDecimal saldo(){
        return this.saldo;
    }

}
