package unbreakable.shop.auto.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.users.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserNameAndUserPassword(String name, String password);
}
