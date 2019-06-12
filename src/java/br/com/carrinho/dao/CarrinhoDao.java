
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
    
    public void inserirProdCar(List<Produto> produtossel){
        
    }
    
}
