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
import retosCiclo4.Retos_2_3_4_5.model.CleaningProduct;
import retosCiclo4.Retos_2_3_4_5.repository.CleaningProductRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository cleaningProduct;

    public List<CleaningProduct> getAll() {
        return cleaningProduct.getAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(Integer id) {
        return cleaningProduct.getCleaningProduct(id);
    }

    public CleaningProduct create(CleaningProduct product) {
        if (product.getId()== null) {
            return product;
        } else {
            return cleaningProduct.create(product);
        }
    }

    public CleaningProduct update(CleaningProduct product) {

        if (product.getId() != null) {
            Optional<CleaningProduct> productDb = cleaningProduct.getCleaningProduct(product.getId());
            if (!productDb.isEmpty()) {

                if (product.getBrand() != null) {
                    productDb.get().setBrand(product.getBrand());
                }

                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                
                if (product.getPresentation() != null) {
                    productDb.get().setPresentation(product.getPresentation());
                }

                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                cleaningProduct.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getCleaningProduct(id).map(accesory -> {
            cleaningProduct.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
   public List<CleaningProduct> productByPrice(double price) {
        return cleaningProduct.productByPrice(price);
    }

    public List<CleaningProduct> findByDescriptionLike(String description) {
        return cleaningProduct.findByDescriptionLike(description);
    }
}
