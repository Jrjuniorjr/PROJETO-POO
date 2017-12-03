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
        this.setState((State) new StateNaoVisualizado());
        
   }    
   public void setState(State state){
       this.state = state;
   }
 
   public int getState(){
       if(state instanceof StateNaoVisualizado){
           return 0;
       }
       else if(state instanceof StateVisualizado){
           return 1;
       }
       else if(state instanceof StatePronto){
           return 2;
       }
       else{
           return 3;
       }
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

    public void proximoEstadoPedido() {
        this.state.proximoEstadoPedido(this);
    }

}
