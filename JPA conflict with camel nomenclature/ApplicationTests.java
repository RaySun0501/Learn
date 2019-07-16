package season.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import season.spring.domain.User;
import season.spring.domain.User1;
import season.spring.service.User1Service;
import season.spring.service.UserService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
    }


    @Test
    public void sqlTest() {

        String sql = "select userId, userName, userAccount, password from user";

        List<User> userList = (List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {

                User user = new User();

                user.setUserId(rs.getInt("userId"));

                user.setUserName(rs.getString("userName"));

                user.setUserAccount(rs.getString("userAccount"));

                return user;

            }

        });

        System.out.println("query successful: ");

        for (User user: userList) {

            System.out.println("userId: " + user.getUserId() + "  userName：" + user.getUserName() + "  userAccount: " + user.getUserAccount());

        }

    }


    @Test
    public void testRepository() {

        // 查询所有数据
        List<User> userList = userService.findAll();

        System.out.println("findAll()：" + userList.size());

        // 精确查询
        List<User> userList1 = userService.findByUserName("Sun");

        System.out.println("findByUserName()：" + userList1.size());

        Assert.isTrue(userList1.get(0).getUserName().equals("Sun"), "data error!");


        User user0 = userService.findByUserId(1);
        System.out.println(user0.getUserName());


        // 模糊查询
        List<User> userList2 = userService.findByUserNameLike("%u%");

        System.out.println("findByUserNameLike()：" + userList2.size());

        Assert.isTrue(userList2.get(0).getUserName().equals("Sun"), "data error!");


        // 通过id列表查询数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> userList3 = userService.findByUserIdIn(ids);

        System.out.println("findByUserIdIn()：" + userList3.size());


        // 分页查询
        PageRequest pr = new PageRequest(0, 10);
        Page<User> userList4 = userService.findAll(pr);
        System.out.println("page findAll(): " + userList4.getTotalPages() + "/" + userList4.getSize());

        User user = new User();

        user.setUserId(3);
        user.setUserName("spring");
        user.setUserAccount("275514");
        user.setPassword("197400");

        userService.save(user);

        // 删除数据
        userService.delete(2);

    }



    @Resource
    private User1Service userService1;

    @Test
    public void testRepository1() {

//        User1 user0 = userService1.findById(1);
//        System.out.println(user0.getName() + user0.getUseraccount());



//        // 账号查找
//        List<User1> userList3 = userService1.findByAccount("123");
//
//        System.out.println("findByAccount()：" + userList3.size());


        // 精确查询
        List<User1> userList1 = userService1.findByName("Sun");

        System.out.println("findByName()：" + userList1.size());


        // 账号查找
//        List<User1> userList2 = userService1.findByUseraccount("123");
//        System.out.println("findByUseraccount()：" + userList2.size());


        // 账号查找
        List<User1> userList3 = userService1.findByUserAccount("456");
        System.out.println("findByUserAccount()：" + userList3.size());

    }


}
