//package unbreakable.shop.auto.bootstrap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import unbreakable.shop.auto.entity.users.User;
//
//import unbreakable.shop.auto.repository.UserRepository;
//
//@Component
//public class Bootstrap implements CommandLineRunner {
//    @Autowired
//    private  UserRepository userRepository;
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user = new User();
//        user.setUserName("a");
//        user.setUserPassword("a");
//        user.setIsAdmin(true);
//        userRepository.save(user);
//        System.out.println(user.getUserName());
//
//    }
//}
