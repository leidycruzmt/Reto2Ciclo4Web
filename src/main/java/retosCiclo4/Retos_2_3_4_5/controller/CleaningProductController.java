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
import retosCiclo4.Retos_2_3_4_5.model.CleaningProduct;
import retosCiclo4.Retos_2_3_4_5.service.CleaningProductService;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningProductController {

    @Autowired
    private CleaningProductService accessoryService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getCleaningProduct(@PathVariable("id") Integer id) {
        return accessoryService.getCleaningProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct product) {
        return accessoryService.create(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct product) {
        return accessoryService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return accessoryService.delete(id);
    }
    
    //Reto 5
    @GetMapping("/price/{price}")
    public List<CleaningProduct> gadgetsByPrice(@PathVariable("price") double precio) {
        return accessoryService.productByPrice(precio);
    }
    //Reto 5
    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionLike(@PathVariable("description") String description) {
        return accessoryService.findByDescriptionLike(description);
    }

}
