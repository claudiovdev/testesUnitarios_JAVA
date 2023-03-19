package br.com.testesUnitarios.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste no utilitário de sumulador de espera")
class SimuladorEsperaTest {

    @Test
    public void deveEsperarENaoDarTimeOut(){
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }

}