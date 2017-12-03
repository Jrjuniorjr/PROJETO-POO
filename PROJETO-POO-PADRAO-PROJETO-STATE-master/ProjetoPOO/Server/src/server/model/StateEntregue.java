/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

/**
 *
 * @author junior
 */
public class StateEntregue implements State{

    @Override
    public void proximoEstadoPedido(Pedido pedido) {
        //pedido.setState(Null);
        pedido.setState(new StateEntregue());
    }

    
}
