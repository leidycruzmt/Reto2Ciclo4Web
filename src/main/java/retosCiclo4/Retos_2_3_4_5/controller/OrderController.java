/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import retosCiclo4.Retos_2_3_4_5.model.Order;
import retosCiclo4.Retos_2_3_4_5.service.OrderService;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")

public class OrderController {
    @Autowired
    private OrderService ordersService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return ordersService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return ordersService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return ordersService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return ordersService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return ordersService.delete(id);
    }

    //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return ordersService.findByZone(zona);
    }
    //Métodos del reto 4
	//Reto 4: Ordenes de un asesor
	@GetMapping("/salesman/{id}")
	public List<Order> ordersSalesManByID(@PathVariable("id") Integer id){
    	return ordersService.ordersSalesManByID(id);
	}
    
 	//Reto 4: Ordenes de un asesor x Estado
	@GetMapping("/state/{state}/{id}")
	public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
    	return ordersService.ordersSalesManByState(state, id);
	}
    
	//Reto 4: Ordenes de un asesor x fecha
	@GetMapping("/date/{date}/{id}")
	public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
    	return ordersService.ordersSalesManByDate(dateStr,id);
	}

}
