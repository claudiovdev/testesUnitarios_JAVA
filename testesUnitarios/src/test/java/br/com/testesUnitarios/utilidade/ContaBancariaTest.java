package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    @Test
    public void deveReceberValorDiferenteDeNulo(){
        var valor = BigDecimal.valueOf(50);

        ContaBancaria contaBancaria = new ContaBancaria(valor);

        assertEquals(new BigDecimal(50), contaBancaria.saldo());
    }

    @Test
    public void deveLancarExceptionAoIniciarUmaContaComNulo(){

        assertThrows(IllegalArgumentException.class, ()-> new ContaBancaria(null));
    }

    @Test
    public void deveRealizarSaqueAoReceberUmValorPositovo(){

        var valorInicialDaConta = BigDecimal.valueOf(100);
        var valorParaSaque = BigDecimal.valueOf(20);
        var resultadoDoSaque = valorInicialDaConta.subtract(valorParaSaque);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        contaBancaria.saque(valorParaSaque);

        assertEquals(new BigDecimal(80), contaBancaria.saldo());
    }

    @Test
    public void deveLancarExceptionAoInserirValorNuloParaSaque(){

        var valorInicialDaConta = BigDecimal.valueOf(100);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.saque(null));
    }

    @Test
    public void deveLancarExceptionQuandoSaqueForMenorQueZero(){

        var valorInicialDaConta = BigDecimal.valueOf(100);
        var valorMenorQueZero = BigDecimal.valueOf(-1);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);
        Executable executable = ()-> contaBancaria.saque(valorMenorQueZero);

        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void deveLancarExceptionQuandoSaqueForIgualAZero(){

        var valorInicialDaConta = BigDecimal.valueOf(100);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.saque(BigDecimal.ZERO));
    }

    @Test
    public void deveLancarExceptionSeOSaldoForMenorQueOValorDeSaque(){

        var valorInicialDaConta = BigDecimal.valueOf(100);
        var valorDeSaque = BigDecimal.valueOf(110);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertThrows(RuntimeException.class, ()-> contaBancaria.saque(valorDeSaque));
    }

    @Test
    public void deveLancarExceptionQuandoValorDoDepositoForNulo(){
        var valorInicialDaConta = BigDecimal.valueOf(100);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.deposito(null));
    }

    @Test
    public void deveLancarExceptionQuandoValorDoDepositoForMenorQueZero(){

        var valorInicialDaConta = BigDecimal.valueOf(100);
        var valorMenorQueZero = BigDecimal.valueOf(-1);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertThrows(IllegalArgumentException.class, ()-> contaBancaria.deposito(valorMenorQueZero));
    }

    @Test
    public void deveRetornarSaldoDaConta(){

        var valorInicialDaConta = BigDecimal.valueOf(100);
        var valorEsperadoNaConta = BigDecimal.valueOf(100);

        ContaBancaria contaBancaria = new ContaBancaria(valorInicialDaConta);

        assertEquals(new BigDecimal(100), contaBancaria.saldo());
    }
}