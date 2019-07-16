package season.spring.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User1 {

    @Id
    private Integer id;
    private String name;
    private String account;




    private String userAccount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }



//    private String useraccount;
//
//
//    public String getUseraccount() {
//        return useraccount;
//    }
//
//    public void setUseraccount(String useraccount) {
//        this.useraccount = useraccount;
//    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
