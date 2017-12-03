
package server.controllers;

import java.util.ArrayList;
import java.util.List;

import persistencia.ContaClienteArquivoDAO;
import persistencia.InterfacePersistencia;
import persistencia.PedidoArquivoDAO;
import persistencia.PersistenciaImplementado;
import server.model.ContaLoja;
import server.model.Pedido;

public class ControllerPedido {
	private InterfacePersistencia bancoPedido = new PersistenciaImplementado( new PedidoArquivoDAO() );	
    
    
    public ArrayList<Pedido> getTodasPedidos() {
    	ArrayList<Pedido> lista = new ArrayList<>();
        
    	for(Object loja : bancoPedido.getTodos()) {
    		lista.add((Pedido)loja);
    	}
    	return lista;
    	
    }
    
    public void addPedido(Pedido p){
        bancoPedido.salvar(p);
    }    
    
    public boolean removerPedido(String idLoja, String idPedido){
        List<Object> pedidosLoja = bancoPedido.getTodos();
        if(!pedidosLoja.isEmpty()){
            for(Object p : pedidosLoja){
                if(((Pedido) p).getId().equals(idPedido)){
                    bancoPedido.apagar(idPedido);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Pedido buscarPedido(String id){
        
        return (Pedido) bancoPedido.buscar(id);
    }
    
    public ArrayList<Pedido> novosPedidos(String idLoja){
        List<Object> todos = null;
        ArrayList<Pedido> novos = new ArrayList<>();
        todos = bancoPedido.getTodos();
        if(!todos.isEmpty()){
            for (Pedido p : todos){
                if(p.getState() == 0){
                    novos.add(p);
                }
            }
            
            if(novos.isEmpty()){
                return null;
            }
            
            return novos;
        }
        return null;
    }
}
