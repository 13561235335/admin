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
@Table(name = "site_account_permissions")
@TableName("site_account_permissions")
@ApiModel(value = "测试")
public class SiteAccountPermissions extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("site_account_id")
    @ApiModelProperty(value = "site_account_id")
    private String siteAccountId;

    @TableField("type")
    @ApiModelProperty(value = "type")
    private String type;

    @TableField("times")
    @ApiModelProperty(value = "times")
    private Integer times;

    @TableField("total_times")
    @ApiModelProperty(value = "total_times")
    private Integer totalTimes;

    @TableField("usage_times_of_day")
    @ApiModelProperty(value = "usage_times_of_day")
    private Integer usageTimesOfDay;

    @TableField("state")
    @ApiModelProperty(value = "state")
    private Boolean state;

}