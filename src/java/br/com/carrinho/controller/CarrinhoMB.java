package br.com.carrinho.controller;

import br.com.carrinho.domain.Produto;
import br.com.carrinho.util.UtilMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoMB implements Serializable{

    private List<Produto> carrinho;
    private float total;

    public CarrinhoMB(List<Produto> carrinho, float total) {
        this.carrinho = carrinho;
        this.total = total;
    }

    public CarrinhoMB() {
        this.carrinho = new ArrayList<>();
        this.listar();
        
    }
    
    public ArrayList<Produto> listar(){
        return (ArrayList<Produto>) carrinho;
    }
       
    public String inserir(Produto produto){
        
        boolean controle = false;
        
        
        for (Produto c: carrinho){
            if (produto.equals(c)){
                c.setQtde(c.getQtde()+1);
                this.listar();
                controle = true;
                for(Produto p : carrinho){
                    setTotal((float) (getTotal() + p.getPreco()));
                }
                return "list.xhtml?faces-redirect=true";
            }
        }

        if (!controle){
            produto.setQtde(1);
            carrinho.add(produto);
            for(Produto p : carrinho){
                setTotal((float) (getTotal() + p.getPreco()));
            }
            UtilMessages.messageInfo("Produto inserido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao inserir o produto!");
            return "list.xhtml?faces-redirect=true";
        }
    }
    
    public String excluir(Produto produto){        
        if (carrinho.remove(produto)){
            UtilMessages.messageInfo("Produto excluído com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir o produto!");
            return null;
        }
    }
        
    public String esvaziarCarrinho(){
        carrinho.clear();
        UtilMessages.messageInfo("Compra Finalizada! Obrigado e Volte Sempre.");
        return "list.xhtml?faces-redirect=true";
    }

    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String home(){
        return "index";
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public String finalizar(){
        return "finalizarcompra.xhtml?faces-redirect=true";
    }

    
}
