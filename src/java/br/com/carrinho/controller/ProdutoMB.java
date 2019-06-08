package br.com.carrinho.controller;

import br.com.carrinho.domain.Produto;
import br.com.carrinho.services.ProdutoService;
import br.com.carrinho.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB implements Serializable{

    private Produto produto;
    private List<Produto> produtos;
    
    public ProdutoMB() {
        this.listar();
    }
    
    public void listar(){
        ProdutoService service = new ProdutoService();
        produtos = service.listar();
    }
    
    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        ProdutoService service = new ProdutoService();
        if (service.inserir(produto)){
            UtilMessages.messageInfo("Produto cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a produto!");
            return null;
        }
    }
    
    public String alterar(){
        ProdutoService service = new ProdutoService();
        if (service.alterar(produto)){
            UtilMessages.messageInfo("Produto alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a produto!");
            return null;
        }
    }
    
    public String carregarDados(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Produto produto){
        ProdutoService service = new ProdutoService();
        if (service.excluir(produto)){
            UtilMessages.messageInfo("Produto excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a produto!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
