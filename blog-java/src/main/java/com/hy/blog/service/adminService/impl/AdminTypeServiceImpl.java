package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminTypeDAO;
import com.hy.blog.entity.Type;
import com.hy.blog.exception.NotFoundException;
import com.hy.blog.service.adminService.AdminTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService {

    @Autowired
    private AdminTypeDAO adminTypeDAO;

    @Override
    public Integer saveType(String name) {
        return adminTypeDAO.saveType(name);
    }

    @Override
    public Integer deleteByIdType(Long id) {
        return adminTypeDAO.deleteByIdType(id);
    }

    @Override
    public Integer updateByIdType(Type type) {
        Type byIdType = adminTypeDAO.findByIdType(type.getId());
        if (byIdType == null) {
            throw new NotFoundException("抱歉不存在次分类！");
        }
        BeanUtils.copyProperties(type, byIdType);
        return adminTypeDAO.updateByIdType(byIdType);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Type findByIdType(Long id) {
        return adminTypeDAO.findByIdType(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Type findByNameType(String name) {
        return adminTypeDAO.findByNameType(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Type> findAllType() {
        return adminTypeDAO.findAllType();
    }

}
