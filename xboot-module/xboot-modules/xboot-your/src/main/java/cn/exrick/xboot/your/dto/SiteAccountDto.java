package cn.exrick.xboot.your.dto;

import cn.exrick.xboot.core.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lw
 */
@Data
@ApiModel(value = "站点表")
public class SiteAccountDto extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    /***** Site *******/

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "download_url")
    private String downloadUrl;

    @ApiModelProperty(value = "taobao_store_name")
    private String taobaoStoreName;

    /***** SiteAccountNumber *******/

    @ApiModelProperty(value = "site_account")
    private String siteAccount;

    @ApiModelProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "cookie")
    private String cookie;

    /***** SiteAccountPermissions *******/

    @ApiModelProperty(value = "type")
    private String type;

    @ApiModelProperty(value = "times")
    private Integer times;

    @ApiModelProperty(value = "total_times")
    private Integer totalTimes;

    @ApiModelProperty(value = "usage_times_of_day")
    private Integer usageTimesOfDay;

}