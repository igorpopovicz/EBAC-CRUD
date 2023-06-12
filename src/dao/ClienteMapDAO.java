package src.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import src.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{

            //chave conteudo
  private Map<Long, Cliente> map;

  public ClienteMapDAO() {
    this.map = new HashMap<>();
  }

  @Override
  public Boolean cadastrar(Cliente cliente) {
    if(map.containsKey(cliente.getCpf())){return false;}
    this.map.put(cliente.getCpf(), cliente);
    return true;
  }

  @Override
  public void excluir(Long cpf) {
    Cliente clienteCadastrado = this.map.get(cpf);

    if(clienteCadastrado != null){map.remove(cpf, clienteCadastrado);}
    
  }

  @Override
  public void alterar(Cliente cliente) {
    Cliente clienteCadastrado = this.map.get(cliente.getCpf());
    if(clienteCadastrado != null){map.remove(cliente.getCpf());}

    map.put(cliente.getCpf(), cliente);

    /*
     * ou
     * 
     * if(clienteCadastrado != null){
     *  clieteCadastrado.setNome(cliente.getNome());
     *  clieteCadastrado.setTel(cliente.getTel());
     *  clieteCadastrado.setNumero(cliente.getNumero());
     *  etc...
     * 
     * }
     */
  }

  @Override
  public Cliente consultar(Long cpf) {
    Cliente clienteCadastrado = this.map.get(cpf);
  
    return clienteCadastrado;
  }

  @Override
  public Collection<Cliente> buscarTodos() {
    return this.map.values();
  } 

}