package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudar(){
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void deveLancarException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(25));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    @Disabled("Não é mais aplicavel")
    public void naoDeveLancarException(){
        assertDoesNotThrow(()-> SaudacaoUtil.saudar(0));
    }
}