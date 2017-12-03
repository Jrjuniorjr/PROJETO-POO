
package server.views;

import java.util.ArrayList;
import server.model.ContaCliente;
import server.model.Item;
import server.model.Pedido;


public class TelaChecarPedidoCliente {

    public void mostrarPedido(ContaCliente cliente){
    
        int item = 1;
        
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>)cliente.getTodosPedidos();
       
        if(pedidos != null){
        	
            for(Pedido p: pedidos){
            
            	System.out.println("--------------------------------");
                System.out.println("ID: " + p.getId());           
                
                for(Item i: p.getItens()){
                    System.out.println("Item: "+item +"      Produto: "+i.getProduto().getNome()+"        "+ "   Desc: "+i.getProduto().getDescricao()+ " Qtd: "+i.getQuantidade()+"        R$"+i.getProduto().getPreco());
                    item++;
                }
                
                System.out.println("Voucher: " + p.getVoucherO());
                System.out.println("Preço Total: "+p.getPreco());
                
                item = 1;
                switch(p.getState()){
                    case 0:
                        System.out.println("Não Visisualizado");
                        break;
                    case 1:
                        System.out.println("Visualizado");
                        break;
                    case 2:
                        System.out.println("Pronto");
                        break;
                    case 3:
                        System.out.println("Entregue");
                        break;
                    default:
                        System.out.println("ERRO");
                        
                }
                
               System.out.println("--------------------------------"); 
            }
        }else{
            System.out.println("Você não possui pedidos");
        }
        
    }
    
}
