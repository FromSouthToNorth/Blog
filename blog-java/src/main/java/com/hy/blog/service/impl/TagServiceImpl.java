package com.hy.blog.service.impl;

import com.hy.blog.dao.TagDAO;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.TagService;
import com.hy.blog.vo.DataStringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Override
    public List<Tag> findBlogTag() {
        return tagDAO.findBlogTag();
    }

    @Override
    public List<DataStringValue> findHomeTag() {
        return tagDAO.findHomeTag();
    }

    @Override
    public List<DataStringValue> findAllTat() {
        return tagDAO.findAllTag();
    }

}
