//package cn.exrick.xboot.your.entity;
//
//import cn.exrick.xboot.core.base.XbootBaseEntity;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiModel;
//import lombok.Data;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
///**
// * @author admin
// */
//@Data
//@Entity
//@DynamicInsert
//@DynamicUpdate
//@Table(name = "request_user")
//@TableName("request_user")
//@ApiModel(value = "请求用户表")
//public class RequestUserJPA extends XbootBaseEntity {
//
//    private static final long serialVersionUID = 1L;
//
//    @TableField("account")
//    @ApiModelProperty(value = "account")
//    private String account;
//
//    @TableField("password")
//    @ApiModelProperty(value = "password")
//    private String password;
//
//    @TableField("salt_value")
//    @ApiModelProperty(value = "salt_value")
//    private String saltValue;
//}