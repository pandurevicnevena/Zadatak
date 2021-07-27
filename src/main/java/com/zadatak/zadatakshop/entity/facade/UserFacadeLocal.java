
package com.zadatak.zadatakshop.entity.facade;

import com.zadatak.zadatakshop.entity.User;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(String username, String password, String name, String surname);
    public User login(String username, String password);
    public User findByUsername(String username);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
}
