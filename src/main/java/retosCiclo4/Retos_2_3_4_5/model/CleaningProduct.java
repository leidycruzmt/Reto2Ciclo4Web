/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author USUARIO
 */
@Document(collection = "cleaningproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningProduct {

    @Id
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private Double price;
    private boolean availability = true;
    private Integer quantity;
    private String photography;
    
}
