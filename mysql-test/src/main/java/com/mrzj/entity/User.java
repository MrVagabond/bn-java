package com.mrzj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
@TableName("user")
public class User {
    @TableId
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("level")
    private int level;

    @TableField("win_count")
    private int winCount;

    @TableField("loss_count")
    private int lossCount;
}
