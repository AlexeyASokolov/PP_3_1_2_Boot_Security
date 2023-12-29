package ru.rishaleva.springBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rishaleva.springBootSecurity.Dao.RoleDao;
import ru.rishaleva.springBootSecurity.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}
