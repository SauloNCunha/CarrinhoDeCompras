
package br.com.carrinho.dao;

import br.com.carrinho.domain.Carrinho;
import br.com.carrinho.domain.Produto;
import java.util.List;
import java.util.ArrayList;


public class CarrinhoDao {
    
    Carrinho carrinho = new Carrinho();
    List<Carrinho> listaCar = new ArrayList<>();
    
    public List<Carrinho> listar(){
        return this.carrinho.getCarrinhos();
    }
    
    public Carrinho consultar(Integer id){
        Carrinho c = new Carrinho();
        for(int i=0; i < carrinho.getCarrinhos().size();i++){
           if(listaCar.get(i).getId() == id){
              c = listaCar.get(i); 
           
           } else {
               c = null;
           }
        }
        return c;
    }
    
    public Boolean inserir(Carrinho carrinho){
       listaCar.add(carrinho);
       return true;
    }
    
    public void inserirProdCar(List<Carrinho> produtossel){
        
    }
    
    public Boolean excluir(Carrinho carrinho){
        Boolean resul = false; 
        for(int i = 0; i < listaCar.size(); i++){
          if(listaCar.get(i) == carrinho){
             listaCar.remove(i);
             resul = true;
          } 
      }
        return resul;
    }
    
    public Boolean alterar(Carrinho carrinho){
        Boolean resul = false; 
        for(int i = 0; i < listaCar.size(); i++){
          if(listaCar.get(i) == carrinho){
             listaCar.add(i,carrinho);
             resul = true;
          } 
      }
        return resul;
    }
}
