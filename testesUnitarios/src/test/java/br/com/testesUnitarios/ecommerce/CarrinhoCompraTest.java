package br.com.testesUnitarios.ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoCompraTest {

    CarrinhoCompra carrinhoCompra;
    Cliente cliente;

    ItemCarrinhoCompra itemCarrinhoCompra;

    Produto produto;
    Produto produto2;

    List<ItemCarrinhoCompra> itemCarrinhoCompras;

    @BeforeEach
    void beforeEach(){

        cliente = new Cliente(1L, "Vinicius");

        produto = new Produto(1L, "Casa", "Uma casa", new BigDecimal(20));
        produto2 = new Produto(1L, "Carro", "Um carro", new BigDecimal(50));

       itemCarrinhoCompras = new ArrayList<>();

        carrinhoCompra = new CarrinhoCompra(cliente, itemCarrinhoCompras);


    }

    @Nested
    @DisplayName("Quando adicionar produto")
    class adicioarProdutoAoCarrinho{
        @Test
        public void deveAdicionarProdutoAoCarrinho(){
            Produto resultado = new Produto(1L, "Casa", "Uma casa", new BigDecimal(20));

            carrinhoCompra.adicionarProduto(produto, 2);

            assertAll(
                    () -> assertEquals(resultado.getId(),carrinhoCompra.getItens().get(0).getProduto().getId()),
                    () -> assertEquals(resultado.getNome(),carrinhoCompra.getItens().get(0).getProduto().getNome()),
                    () -> assertEquals(resultado.getDescricao(),carrinhoCompra.getItens().get(0).getProduto().getDescricao())
            );

        }

        @Test
        public void deveLancarExceptionAoAdicionarQuantidadeDeProdutoMenorQueZero(){
            assertThrows(IllegalArgumentException.class, ()-> carrinhoCompra.adicionarProduto(produto, 0));
        }
    }
}