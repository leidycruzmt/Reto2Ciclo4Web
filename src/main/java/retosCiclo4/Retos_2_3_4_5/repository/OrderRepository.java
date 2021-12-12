/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import retosCiclo4.Retos_2_3_4_5.interfaces.OrderInterface;
import retosCiclo4.Retos_2_3_4_5.model.Orders;

/**
 *
 * @author USUARIO
 */

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderInterface orderCrudRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Orders> getAll() {
        return (List<Orders>) orderCrudRepository.findAll();
    }

    public Optional<Orders> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Orders create(Orders order) {
        return orderCrudRepository.save(order);
    }

    public void update(Orders order) {
        orderCrudRepository.save(order);
    }

    public void delete(Orders order) {
        orderCrudRepository.delete(order);
    }

    public Optional<Orders> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Orders> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
    //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    public List<Orders> ordersSalesManByID(Integer id) {
        Query query = new Query();
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<Orders> orders = mongoTemplate.find(query, Orders.class);
        
        return orders;
        
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Orders> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                            .and("status").is(state);
        
        query.addCriteria(criterio);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;
    }
    
    //Reto 4: Ordenes de un asesor x Fecha
    public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
			.gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
			.lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
			.and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;       
    }
}
