package season.spring.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import season.spring.domain.User;
import season.spring.repository.UserRepository;
import season.spring.service.UserService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByUserId(Integer userId) {

        return userRepository.findById(userId).get();

    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();

    }

    @Override
    public User save(User user) {

        return userRepository.save(user);

    }

    @Override
    public void delete(Integer userId) {

        userRepository.deleteById(userId);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {

        return userRepository.findAll(pageable);

    }

    @Override
    public List<User> findByUserName(String userName) {

        return userRepository.findByUserName(userName);

    }

    @Override
    public List<User> findByUserNameLike(String userName) {

        return userRepository.findByUserNameLike(userName);

    }

    @Override
    public List<User> findByUserIdIn(Collection<Integer> ids) {

        return userRepository.findByUserIdIn(ids);

    }

}
