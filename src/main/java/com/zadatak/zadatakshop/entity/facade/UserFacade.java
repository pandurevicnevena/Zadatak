
package com.zadatak.zadatakshop.entity.facade;

import com.zadatak.zadatakshop.entity.Privilege;
import com.zadatak.zadatakshop.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User login(String username, String password) {
        
        try {
            return (User) entityManager.createNamedQuery("User.findByUsernameAndPassword")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean register(String username, String password, String name, String surname) {
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername");
            query.setParameter("username", username);
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                Privilege privilege = (Privilege) entityManager.createNamedQuery("Privilege.findByPrivilegeId").setParameter("privilegeId", 2).getSingleResult();
                User user = new User();
                user.setUsername(username);
                user.setPasword(password);
                user.setName(name);
                user.setSurname(surname);
                user.setPrivilegeId(privilege);
                entityManager.persist(user);
                return true;
            }else{
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
