package src.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import src.domain.Cliente;

public class ClienteSetDAO implements IClienteDAO {

  private Set<Cliente> set;

  public ClienteSetDAO(){
    this.set = new HashSet<>();
  }

  @Override
  public Boolean cadastrar(Cliente cliente) {
    if(this.set.contains(cliente)){return false;}
    this.set.add(cliente);
    return true;
  }

  @Override
  public void excluir(Long cpf) {
    if(!set.isEmpty()){
      set.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }
  }

  @Override
  public void alterar(Cliente cliente) {
    if(set.contains(cliente)){
      excluir(cliente.getCpf());
    }
    cadastrar(cliente);
  }

  @Override
  public Cliente consultar(Long cpf) {
    for (Cliente cliente : set) {
      if(cliente.getCpf().equals(cpf)){
        return cliente;
      }
    }
    return null;
  }

  @Override
  public Collection<Cliente> buscarTodos() {
    return set;
  }
  
}
