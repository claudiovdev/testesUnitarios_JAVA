package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    public void deveRetornarBomDia(){
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void deveRetornarBoaTarde(){
        String saudacao = SaudacaoUtil.saudar(12);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void deveRetornarBoaNoite(){
        String saudacao = SaudacaoUtil.saudar(23);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    public void deveRetornarBomDiaApartirDas5h(){
        String saudacao = SaudacaoUtil.saudar(5);
        assertEquals("Bom dia", saudacao);
    }
    @Test
    public void deveRetornarBoaNoiteAteAs4h(){
        String saudacao = SaudacaoUtil.saudar(4);
        assertEquals("Boa noite", saudacao);
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