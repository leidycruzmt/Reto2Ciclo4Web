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
import retosCiclo4.Retos_2_3_4_5.model.Order;
import retosCiclo4.Retos_2_3_4_5.repository.OrderRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository ordersRepository;

    public List<Order> getAll() {
        return ordersRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return ordersRepository.getOrder(id);
    }

    public Order create(Order orders) {

        //obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = ordersRepository.lastUserId();

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

        Optional<Order> e = ordersRepository.getOrder(orders.getId());
        if (e.isEmpty()) {
            return ordersRepository.create(orders);
        } else {
            return orders;
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = ordersRepository.getOrder(order.getId());
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
    public List<Order> findByZone(String zona) {
        return ordersRepository.findByZone(zona);
    }
    
     //Métodos del reto 4
	//Reto 4: Ordenes de un asesor
	public List<Order> ordersSalesManByID(Integer id){
    	return ordersRepository.ordersSalesManByID(id);
	}
//Reto 4: Ordenes de un asesor x Estado
	public List<Order> ordersSalesManByState(String state, Integer id){
    	return ordersRepository.ordersSalesManByState(state, id);
	}
    
	//Reto 4: Ordenes de un asesor x fecha
	public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
    	return ordersRepository.ordersSalesManByDate(dateStr,id);
	}

}
