
package br.com.carrinho.dao;

import br.com.carrinho.domain.Produto;
import br.com.carrinho.domain.Carrinho;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;




public class ProdutoDao {
    
    Produto produto = new Produto();
    List<Produto> listaProd = new ArrayList<>();
    
    public List<Produto> listar(){
        return this.produto.getProdutos();
    }
    
    public Produto consultar(Integer id){
        Produto c = new Produto();
        for(int i=0; i < produto.getProdutos().size();i++){
           if(listaProd.get(i).getId() == id){
              c = listaProd.get(i); 
           
           } else {
               c = null;
           }
        }
        return c;
    }
    
    public Boolean inserir(Produto produto){
       listaProd.add(produto);
       return true;
    }
    
    public void inserirProdCar(List<Produto> produtossel){
        Carrinho sacola = new Carrinho();
        List<Carrinho> listaSacola = new ArrayList<>();
        //listaSacola.add((List<Carrinho>) produtossel);
               
    }
    
    public Boolean excluir(Produto produto){
        Boolean resul = false; 
        for(int i = 0; i < listaProd.size(); i++){
          if(listaProd.get(i) == produto){
             listaProd.remove(i);
             resul = true;
          } 
      }
        return resul;
    }
    
    public Boolean alterar(Produto produto){
        Boolean resul = false; 
        for(int i = 0; i < listaProd.size(); i++){
          if(listaProd.get(i) == produto){
             listaProd.add(i,produto);
             resul = true;
          } 
      }
        return resul;
    }
    

    
}
