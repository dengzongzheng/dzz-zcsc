package com.dzz.zcsc.service.impl;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.model.User;
import com.dzz.zcsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * 用户接口mongo下的实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 15:10
 */
@Service
public class UserServiceMongoImpl implements UserService {

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ResponseDzz<User> getUserByName(String userName) {

        Criteria criteria = Criteria.where("user_name").is(userName);
        Query query = new Query();
        query.addCriteria(criteria);
        User user = mongoTemplate.findOne(query, User.class);
        return ResponseDzz.ok(user);
    }

    @Override
    public ResponseDzz<Boolean> saveUser(User user) {

        mongoTemplate.save(user);
        return ResponseDzz.ok(Boolean.TRUE);
    }
}
