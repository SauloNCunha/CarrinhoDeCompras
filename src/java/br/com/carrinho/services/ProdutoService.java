package br.com.carrinho.services;
import br.com.carrinho.dao.ProdutoDao;
import br.com.carrinho.domain.Produto;
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

}    

