package br.com.testesUnitarios.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CarrinhoCompra {

    private final Cliente cliente;
    private final List<ItemCarrinhoCompra> itens;


    public CarrinhoCompra(Cliente cliente, List<ItemCarrinhoCompra> itens) {
        Objects.requireNonNull(cliente);
        Objects.requireNonNull(itens);
        this.cliente = cliente;
        this.itens = itens;
    }

    public List<ItemCarrinhoCompra> getItens() {
        return new ArrayList<>(itens);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        Objects.requireNonNull(produto);
        validaQuantidadeDoProduto(quantidade);
        verificarSeProdutoExisteEAdicionar(produto)
                .ifPresentOrElse(itemCarrinhoCompra -> itemCarrinhoCompra.adicionarQuantidade(quantidade),
                        ()-> adicionarNovoProduto(produto, quantidade));
    }

    private void adicionarNovoProduto(Produto produto, int quantidade) {
        this.itens.add(new ItemCarrinhoCompra(produto, quantidade));
    }


    private Optional<ItemCarrinhoCompra> verificarSeProdutoExisteEAdicionar(Produto produto) {
        return this.itens.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst();
    }

    private void validaQuantidadeDoProduto(int quantidade) {
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade não pode ser menor que zero");
        }
    }

    public void removerProduto(Produto produto) {
        //TODO parâmetro não pode ser nulo, deve retornar uma exception
        //TODO caso o produto não exista, deve retornar uma exception
        //TODO deve remover o produto independente da quantidade
    }

    public void aumentarQuantidadeProduto(Produto produto) {
        //TODO parâmetro não pode ser nulo, deve retornar uma exception
        //TODO caso o produto não exista, deve retornar uma exception
        //TODO deve aumentar em um quantidade do produto
    }

    public void diminuirQuantidadeProduto(Produto produto) {
        //TODO parâmetro não pode ser nulo, deve retornar uma exception
        //TODO caso o produto não exista, deve retornar uma exception
        //TODO deve diminuir em um quantidade do produto, caso tenha apenas um produto, deve remover da lista
    }

    public BigDecimal getValorTotal() {
        //TODO implementar soma do valor total de todos itens
        return null;
    }

    public int getQuantidadeTotalDeProdutos() {
        int quantidadeDeProdutos = 0;
        return this.itens.stream()
                .map(ItemCarrinhoCompra::getQuantidade).reduce(0, (a,b) -> a + b);
    }

    public void esvaziar() {
        this.itens.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoCompra that = (CarrinhoCompra) o;
        return Objects.equals(itens, that.itens) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itens, cliente);
    }

}
