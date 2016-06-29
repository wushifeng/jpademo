package cn.csbit.repository;
import cn.csbit.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wushifeng on 2016/6/27.
 */
@Repository
public interface  UserDao  extends  CrudRepository< User, Integer > {
    public List<User> findByName(String name);

    @Query("select u from User u where u.name = ?1")
    public User findByOwnName(String name);
}
