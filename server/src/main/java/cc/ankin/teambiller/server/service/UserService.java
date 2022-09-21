package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private MongoTemplate mongoTemplate;

    public User add(User user) {
        mongoTemplate.save(user);
        return user;
    }

    public Boolean checkPassword(String email, String password) {
        User user = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("email").is(email)), User.class);
        return user != null && user.password.equals(password);
    }

}
