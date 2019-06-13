package br.com.carrinho.controller;

import br.com.carrinho.domain.Carrinho;
import br.com.carrinho.services.CarrinhoService;
import br.com.carrinho.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoMB implements Serializable{

    private Carrinho carrinho;
    private List<Carrinho> carrinhos;
    
    public CarrinhoMB() {
        this.listar();
    }
    
    public void listar(){
        CarrinhoService service = new CarrinhoService();
        carrinhos = service.listar();
    }
    
    public String novo(){
        carrinho = new Carrinho();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        CarrinhoService service = new CarrinhoService();
        if (service.inserir(carrinho)){
            UtilMessages.messageInfo("Carrinho cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a carrinho!");
            return null;
        }
    }
    
    public String alterar(){
        CarrinhoService service = new CarrinhoService();
        if (service.alterar(carrinho)){
            UtilMessages.messageInfo("Carrinho alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a carrinho!");
            return null;
        }
    }
    
    public String carregarDados(Carrinho carrinho){
        this.carrinho = carrinho;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Carrinho carrinho){
        CarrinhoService service = new CarrinhoService();
        if (service.excluir(carrinho)){
            UtilMessages.messageInfo("Carrinho excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a carrinho!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
