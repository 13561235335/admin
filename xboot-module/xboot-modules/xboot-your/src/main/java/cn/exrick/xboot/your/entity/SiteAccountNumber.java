package cn.exrick.xboot.your.entity;

import cn.exrick.xboot.core.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Exrick
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "site_account_number")
@TableName("site_account_number")
@ApiModel(value = "测试")
public class SiteAccountNumber extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;
    
    @TableField("site_id")
    @ApiModelProperty(value = "site_id")
    private String siteId;

    @TableField("site_account")
    @ApiModelProperty(value = "site_account")
    private String siteAccount;
    
    @TableField("password")
    @ApiModelProperty(value = "password")
    private String password;
    
    @TableField("cookie")
    @ApiModelProperty(value = "cookie")
    private String cookie;
    
    @TableField("state")
    @ApiModelProperty(value = "state")
    private Boolean state;
    
    @TableField("total_times")
    @ApiModelProperty(value = "total_times")
    private Integer totalTimes;
    
    @TableField("usage_times_of_day")
    @ApiModelProperty(value = "usage_times_of_day")
    private Integer usageTimesOfDay;
    
    @TableField("price")
    @ApiModelProperty(value = "price")
    private Double price;

    @TableField("weight_value")
    @ApiModelProperty(value = "weight_value")
    private Integer weightValue;
}