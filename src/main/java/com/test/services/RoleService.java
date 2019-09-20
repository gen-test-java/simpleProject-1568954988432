package com.test.services;

import com.test.entity.Role;
import java.lang.Long;
import java.util.List;

public interface RoleService {

	Role saveRole(Role role) throws Exception;

	Role findRoleById(Long id);

	List<Role> findAllRole();

	void deleteRoleById(Long id);
}