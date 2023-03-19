package br.com.testesUnitarios.blog.negocio;

import br.com.testesUnitarios.blog.modelo.Editor;
import br.com.testesUnitarios.blog.modelo.Ganhos;
import br.com.testesUnitarios.blog.modelo.Post;
import br.com.testesUnitarios.blog.utilidades.ProcessadorTextoSimples;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadora;
    Editor autor;
    Post post;

    @BeforeAll
    static void beforeAll(){
        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }
    @BeforeEach
    void beforeEach(){
         autor = new Editor(1L, "Vinicius", "vinicius@gmail.com", new BigDecimal(5), true);
         post = new Post(1L, "Ecosistema Java", "O ecosistema do java é muito maduro", autor, "Ecosistema-java", null, false, false);

    }

    @Test
    public void deveCalcularGanhor(){
        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal(45), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }
    @Test

    public void deveCalcularGanhorSemPremium(){
        autor.setPremium(false);

        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal(35), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

}