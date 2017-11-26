package server.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private String voucher;
    private List<Item> itens;
    private State state;
    
    public Pedido(String idLoja, String voucher, List<Item> itens){
    
        this.itens = new ArrayList<>();
        
        this.voucher =  voucher;
        this.id = "" + idLoja + this.voucher;   	   
        this.itens = itens;

        
   }    
   public void setState(State state){
       this.state = state;
   }
    
   public String getEstadoPedido(){
       return this.state.estadoPedido();
   }
    public void setEntregue(){
        setState(new StateEntregue());        
    }
    public void setPronto(){
        setState(new StatePronto());
    }
 
    public void setVisualizado(){
        setState(new StateVisualizado());
    }
 
    public String getId() {
        return this.id;
    }

    public String getReferenciaLoja(){
        return id.substring(0, 2);        
    } 
     
    public String getVoucherO(){
        return this.voucher;
    }
     
    
    public double getPreco() {
        double total = 0;

        for(Item item : itens) {
                total += item.getPreco();
        }

        return total;
    }
    
    public List <Item> getItens(){
        return this.itens;
    }

}
