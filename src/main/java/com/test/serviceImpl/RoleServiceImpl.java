package com.test.serviceImpl;

import org.springframework.stereotype.Service;
import com.test.repository.RoleRepository;
import com.test.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.services.RoleService;
import java.lang.Long;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) throws Exception {
		return role;
	}

	@Override
	public Role findRoleById(Long id) {
		Role role = roleRepository.findOne(id);
		return role;
	}

	@Override
	public List<Role> findAllRole() {
		List<Role> roleList = roleRepository.findAll();
		return roleList;
	}

	@Override
	public void deleteRoleById(Long id) {
		roleRepository.delete(id);
	}
}