package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    public void assercaoAgrupada(){

        Pessoa pessoa = new Pessoa("Vinicius", "Magalhães");

        Assertions.assertAll(
                ()-> assertEquals("Vinicius", pessoa.getNome()),
                ()-> assertEquals("Magalhães", pessoa.getSobrenome())
        );
    }

}