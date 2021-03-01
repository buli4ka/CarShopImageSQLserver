//package unbreakable.shop.auto.service.user_service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import unbreakable.shop.auto.entity.users.User;
//import unbreakable.shop.auto.repository.UserRepository;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public boolean getAccess(String name, String password){
//        try {
//            User user = userRepository.findUserByUserNameAndUserPassword(name, password);
//            if (user != null) {
//                return true;
//            }
//        }
//        catch (Exception e){e.printStackTrace();}
//        return false;
//    }
//}
