/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retosCiclo4.Retos_2_3_4_5.model.Orders;
import retosCiclo4.Retos_2_3_4_5.repository.OrderRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository ordersRepository;

    public List<Orders> getAll() {
        return ordersRepository.getAll();
    }

    public Optional<Orders> getOrder(int id) {
        return ordersRepository.getOrder(id);
    }

    public Orders create(Orders orders) {

        //obtiene el maximo id existente en la coleccion
        Optional<Orders> orderIdMaxima = ordersRepository.lastUserId();

        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (orders.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty()) {
                orders.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else {
                orders.setId(orderIdMaxima.get().getId() + 1);
            }
        }

        Optional<Orders> e = ordersRepository.getOrder(orders.getId());
        if (e.isEmpty()) {
            return ordersRepository.create(orders);
        } else {
            return orders;
        }
    }

    public Orders update(Orders order) {

        if (order.getId() != null) {
            Optional<Orders> orderDb = ordersRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                ordersRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            ordersRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Orders> findByZone(String zona) {
        return ordersRepository.findByZone(zona);
    }
    
     //Métodos del reto 4
	//Reto 4: Ordenes de un asesor
	public List<Orders> ordersSalesManByID(Integer id){
    	return ordersRepository.ordersSalesManByID(id);
	}
//Reto 4: Ordenes de un asesor x Estado
	public List<Orders> ordersSalesManByState(String state, Integer id){
    	return ordersRepository.ordersSalesManByState(state, id);
	}
    
	//Reto 4: Ordenes de un asesor x fecha
	public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
    	return ordersRepository.ordersSalesManByDate(dateStr,id);
	}

}
