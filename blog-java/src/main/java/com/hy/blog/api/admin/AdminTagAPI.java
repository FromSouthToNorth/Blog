package com.hy.blog.api.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.adminService.AdminTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminTagAPI {

    @Autowired
    private AdminTagService adminTagService;

    @GetMapping("/pagetags")
    public PageInfo<Tag> tags(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Tag> allTag = adminTagService.findAllTag();
        return new PageInfo<>(allTag);
    }

    @GetMapping("/tags")
    public List<Tag> tags() {
        return adminTagService.findAllTag();
    }

    @PostMapping("/tags")
    public Integer post(Tag tag) {
        if (tag.getName() == null) {
            return 2;
        }
        Integer integer;
        if (tag.getId() != null) {
            integer = adminTagService.updateByIdTag(tag);
        } else {
            Tag byNameTag = adminTagService.findByNameTag(tag.getName());
            if (byNameTag != null) {
                return 1;
            }
            integer = adminTagService.saveTag(tag);
        }
        if (integer > 0) {
            return 0;
        } else {
            return 3;
        }
    }

    @GetMapping("/tag")
    public Tag editInput(Long id) {
        return adminTagService.findByIdTag(id);
    }

    @PostMapping("/tag")
    public Integer editPost(Tag tag) {
        if (tag.getId() == null || tag.getName() == null) {
            return 2;
        }
        Tag byNameTag = adminTagService.findByNameTag(tag.getName());
        if (byNameTag != null) {
            return 1;
        }
        Integer integer = adminTagService.updateByIdTag(tag);
        if (integer < 0) {
            return 3;
        } else {
            return 0;
        }
    }

    @PostMapping("/deleteTag")
    public Integer delete(Long id) {
        if (adminTagService.deleteByIdTag(id) > 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
