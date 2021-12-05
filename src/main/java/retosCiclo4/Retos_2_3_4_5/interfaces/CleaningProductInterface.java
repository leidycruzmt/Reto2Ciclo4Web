/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import retosCiclo4.Retos_2_3_4_5.model.CleaningProduct;

/**
 *
 * @author USUARIO
 */
public interface CleaningProductInterface extends MongoRepository<CleaningProduct, Integer>{
    
}
