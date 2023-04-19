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

    private CarrinhoCompra carrinhoCompra;
    private Cliente cliente;
    private List<ItemCarrinhoCompra> itens;
    private Produto notebook;
    private Produto desktop;
    private Produto tablet;

    @BeforeEach
    public void beforeEach() {
        cliente = new Cliente(1L, "Alex Silva");

        notebook = new Produto(1L, "Notebook", "Notebook", BigDecimal.TEN);
        desktop = new Produto(2L, "Desktop", "Desktop", BigDecimal.valueOf(20.50));
        tablet = new Produto(3L, "Tablet", "Tablet", BigDecimal.valueOf(30.50));

        itens = new ArrayList<>();
        itens.add(new ItemCarrinhoCompra(notebook, 2));
        itens.add(new ItemCarrinhoCompra(desktop, 1));

        carrinhoCompra = new CarrinhoCompra(cliente, itens);
    }

    @Nested
    @DisplayName("Quando retornar itens")
    class QuandoRetornarItens {

        @Test
        @DisplayName("Então deve retornar dois itens")
        void entaoDeveRetornarDoisItens(){
            assertEquals(2, carrinhoCompra.getItens().size());
        }

        @Test
        @DisplayName("E deve retornar uma nova instância da lista de itens")
        void eDeveRetornarUmaNovaLista() {
            carrinhoCompra.getItens().clear(); //Get Itens, retorna uma nova lista
            assertEquals(2, carrinhoCompra.getItens().size()); //Lista permaneceu intacta
        }
    }

    @Nested
    @DisplayName("Quando remover um notebook")
    class QuandoRemoverUmItem{

        @BeforeEach
        public void beforeEach() {
            carrinhoCompra.removerProduto(notebook);
        }

        @Test
        @DisplayName("Então não deve diminuir quantidade total")
        void EntaoNaoDeveDiminuirQuantidadeTotal(){
            assertEquals(1, carrinhoCompra.getItens().size());
        }
    }
}