/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaaplication1.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javaaplication1.domain.Cliente;

/**
 *
 * @author Victo
 */
public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set;

    public ClienteSetDAO(Set<Cliente> set) {
        this.set = new HashSet<>();
    }
    
    public Boolean cadastrar(Cliente cliente){
        return this.set.add(cliente);
    }
    
    public void excluir(Long cpf){
        Cliente clienteEncontrado = null;
        for(Cliente cliente : this.set){
            if(cliente.getCpf().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }
        }
        if(clienteEncontrado != null) {
            this.set.remove(clienteEncontrado);
        }
    }
    
    public void alterar(Cliente cliente){
        if(this.set.contains(cliente)) {
            for(Cliente clienteCadastrado : this.set) {
                if(clienteCadastrado.equals(cliente)) {
                   clienteCadastrado.setNome(cliente.getNome());
                   clienteCadastrado.setTel(cliente.getTel());
                   clienteCadastrado.setEnd(cliente.getEnd());
                   clienteCadastrado.setNum(cliente.getNum());
                   clienteCadastrado.setCidade(cliente.getCidade());
                   clienteCadastrado.setEstado(cliente.getEstado());
                   break;
                }
            }
        }
    }
    
    public Cliente consultar(Long cpf){
        for(Cliente clienteCadastrado : this.set){
            if(clienteCadastrado.getCpf().equals(cpf)){
                return clienteCadastrado;
            }
        }
        return null;
    }
    
    public Collection<Cliente> buscarTodos(){
        return this.set;
    }
}

    
