/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retosCiclo4.Retos_2_3_4_5.model.Orders;

/**
 *
 * @author USUARIO
 */
public interface OrderInterface extends MongoRepository<Orders, Integer>{
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Orders> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Orders> findTopByOrderByIdDesc();
}
