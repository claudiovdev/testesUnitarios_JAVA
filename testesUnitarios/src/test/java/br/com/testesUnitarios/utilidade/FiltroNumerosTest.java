package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiltroNumerosTest {

    @Test
    public void deveRetornarNumerosPares(){
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosEsperados = Arrays.asList(2, 4);
        List<Integer> resultadoDoFiltro = FiltroNumeros.numerosPares(numeros);
        Assertions.assertIterableEquals(numerosEsperados, resultadoDoFiltro);

    }

}