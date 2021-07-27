
package com.zadatak.zadatakshop.entity.facade;

import com.zadatak.zadatakshop.entity.Product;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
}
