package season.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import season.spring.domain.User1;

import java.util.List;

public interface User1Repository extends JpaRepository<User1, Integer> {

    public List<User1> findByName(String name);


    //    public List<User1> findByAccount(String account);

//    public List<User1> findByUseraccount(String userAccount);

    public List<User1> findByUserAccount(String userAccount);


}
