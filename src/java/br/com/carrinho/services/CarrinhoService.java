package br.com.carrinho.services;
import br.com.carrinho.dao.CarrinhoDao;
import br.com.carrinho.domain.Carrinho;
import br.com.carrinho.domain.Produto;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoService {

    private final CarrinhoDao carrinhoDao = new CarrinhoDao();
    
    public List<Carrinho> listar(){     
        return carrinhoDao.listar();      
    }

    public Carrinho consultar(Integer id){
        return carrinhoDao.consultar(id);   
    }

    public boolean inserir (Carrinho carrinho){
        return carrinhoDao.inserir(carrinho);
    }
    
    public boolean inserirProdCar (Produto produto){
        List<Produto> produtos = new ArrayList<>(); 
        List<Produto> produtossel = new ArrayList<>(); 
        
        for(int i = 0 ; i < produtos.size(); i++){
            if(produtos.get(i).getSel() == true){
               produtossel.add(produtos.get(i));
            }
            
        }
        
        return carrinhoDao.inserirProdCar(produtossel);
    }

    public Boolean alterar (Carrinho carrinho){
        return carrinhoDao.alterar(carrinho);
    }

    public boolean excluir (Carrinho carrinho){
        return carrinhoDao.excluir(carrinho);
    }

}    

