package br.com.carrinho.services;
import br.com.carrinho.dao.CarrinhoDao;
import br.com.carrinho.domain.Carrinho;
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
    
    public Boolean alterar (Carrinho carrinho){
        return carrinhoDao.alterar(carrinho);
    }

    public boolean excluir (Carrinho carrinho){
        return carrinhoDao.excluir(carrinho);
    }

}    

