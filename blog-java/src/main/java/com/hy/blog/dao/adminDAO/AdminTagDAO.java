package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminTagDAO {

    Integer saveTag(@Param("name") String name);

    Tag findByIdTag(@Param("id") Long id);

    Tag findByNameTag(@Param("name") String name);

    Integer deleteByIdTag(@Param("id") Long id);

    Integer updateByIdTag(Tag tag);

    List<Tag> findAllTag();

}