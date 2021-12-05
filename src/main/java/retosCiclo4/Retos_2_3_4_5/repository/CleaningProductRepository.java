/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retosCiclo4.Retos_2_3_4_5.interfaces.CleaningProductInterface;
import retosCiclo4.Retos_2_3_4_5.model.CleaningProduct;

/**
 *
 * @author USUARIO
 */

@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProductInterface repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(Integer id) {
        return repository.findById(id);
    }
    public CleaningProduct create(CleaningProduct product) {
        return repository.save(product);
    }

    public void update(CleaningProduct product) {
        repository.save(product);
    }
    
    public void delete(CleaningProduct product) {
        repository.delete(product);
    }
}
