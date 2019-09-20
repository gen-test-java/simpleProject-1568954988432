package com.test.serviceImpl;

import org.springframework.stereotype.Service;
import com.test.repository.UserRepository;
import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.services.UserService;
import java.lang.Long;
import java.util.List;
import com.test.repository.RolesRepository;
import com.test.entity.Roles;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RolesRepository rolesRepository;

	@Override
	public User saveUser(User user) throws Exception {
		User userDB = userRepository.save(user);
		if (user.getRolesList() != null) {
			List<Roles> rolesList = user.getRolesList();
			for (Roles roles : rolesList) {
				roles.setUser(userDB);
				rolesRepository.save(roles);
			}
		}
		return user;
	}

	@Override
	public User findUserById(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}
}