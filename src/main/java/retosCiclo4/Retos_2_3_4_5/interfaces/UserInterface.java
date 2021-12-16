/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import retosCiclo4.Retos_2_3_4_5.model.User;

/**
 *
 * @author USUARIO
 */
public interface UserInterface extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    List<User> findBybirthtDay(Date date);
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
