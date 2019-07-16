package season.spring.service;

import season.spring.domain.User1;

import java.util.List;

public interface User1Service {

//    public User1 findById(Integer id);

//    public List<User1> findByAccount(String account);

    public List<User1> findByName(String name);


//    public List<User1> findByUseraccount(String useraccount);

    public List<User1> findByUserAccount(String userAccount);



}
