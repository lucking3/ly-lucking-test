package com.example.demo.authc.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value="testUser实体",reference ="参考" )//必须要
@TableName("LY_YYGL_YYB")
public class AppsPo {

    private static final long serialVersionUID = 1L;

    @TableId("YYBH")
    private String id;
    @TableField("YYMC")
    private String appName;
    @TableField("YYMS")
    private String appDesc;
    @TableField("ZT")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
