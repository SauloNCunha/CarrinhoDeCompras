package br.com.carrinho.services;
import br.com.carrinho.dao.ProdutoDao;
import br.com.carrinho.domain.Produto;
import java.util.ArrayList;
import java.util.List;


public class ProdutoService {

    private final ProdutoDao produtoDao = new ProdutoDao();
    
    public List<Produto> listar(){     
        return produtoDao.listar();      
    }

    public Produto consultar(Integer id){
        return produtoDao.consultar(id);   
    }

    public boolean inserir (Produto produto){
        return produtoDao.inserir(produto);
    }

    public Boolean alterar (Produto produto){
        return produtoDao.alterar(produto);
    }

    public boolean excluir (Produto produto){
        return produtoDao.excluir(produto);
    }
    
    public List<Produto> inserirProdCar (Produto produto){
        List<Produto> produtos = new ArrayList<>(); 
        List<Produto> produtossel = new ArrayList<>(); 
        
        for(int i = 0 ; i < produtos.size(); i++){
            if(produtos.get(i).getSel() == true){
               produtossel.add(produtos.get(i));
            }
            
        }
        
        return produtossel;
    }

}    

