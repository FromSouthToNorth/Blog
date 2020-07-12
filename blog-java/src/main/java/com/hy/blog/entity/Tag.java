package com.hy.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 标签
public class Tag {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;
    private String tagColour;

    private List<Blog> blogs;

}
