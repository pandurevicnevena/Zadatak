
package com.zadatak.zadatakshop.entity.facade;

import com.zadatak.zadatakshop.entity.Privilege;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PrivilegeFacadeLocal {

    void create(Privilege privilege);

    void edit(Privilege privilege);

    void remove(Privilege privilege);

    Privilege find(Object id);

    List<Privilege> findAll();

    List<Privilege> findRange(int[] range);

    int count();
    
}
