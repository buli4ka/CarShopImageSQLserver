package unbreakable.shop.auto.service.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.users.User;
import unbreakable.shop.auto.repository.user.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(String log, String pass, String role){
        try {
            User user = new User(log,pass,role);
            return userRepository.save(user);
        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }
}
