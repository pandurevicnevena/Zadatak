
package com.zadatak.zadatakshop.entity.facade;

import com.zadatak.zadatakshop.entity.Privilege;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PrivilegeFacade extends AbstractFacade<Privilege> implements PrivilegeFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PrivilegeFacade() {
        super(Privilege.class);
    }
    
}
