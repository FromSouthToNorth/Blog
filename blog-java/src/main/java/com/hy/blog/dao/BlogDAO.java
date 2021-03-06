package com.hy.blog.dao;

import com.hy.blog.entity.Blog;
import com.hy.blog.vo.RecommendBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogDAO {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(@Param("id") Long id);

    void updateByIdBlogViews(Blog blog);

    List<RecommendBlog> findRecommendBlog();

    List<Blog> findByTypeIdBlog(@Param("typeId") Long typeId);

    List<Blog> findByTagIdBlog(@Param("tagId") Long tagId);

    List<String> findBlogYear();

    List<Blog> findByYear(@Param("year") String year);

    Integer countBlog();

    List<Blog> findByTitleBlog(@Param("query") String query);

    String findByIdBlogTitle(@Param("id") Long id);

}
