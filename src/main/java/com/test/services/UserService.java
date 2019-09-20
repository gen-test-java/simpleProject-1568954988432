package com.test.services;

import com.test.entity.User;
import java.lang.Long;
import java.util.List;

public interface UserService {

	User saveUser(User user) throws Exception;

	User findUserById(Long id);

	List<User> findAllUser();

	void deleteUserById(Long id);
}