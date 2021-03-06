/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajplarson.practice.data;

import com.ajplarson.practice.models.Role;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public interface RoleDao {

    Role getRoleById(int id);

    Role getRoleByRole(String role);

    List<Role> getAllRoles();

    void deleteRole(int id);

    void updateRole(Role role);

    Role createRole(Role role);
}
