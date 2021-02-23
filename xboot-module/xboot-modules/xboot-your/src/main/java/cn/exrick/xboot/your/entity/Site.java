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
 * @author lw
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "site")
@TableName("site")
@ApiModel(value = "站点表")
public class Site extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("ip")
    @ApiModelProperty(value = "ip")
    private String ip;

    @TableField("url")
    @ApiModelProperty(value = "url")
    private String url;

    @TableField("downloadUrl")
    @ApiModelProperty(value = "downloadUrl")
    private String downloadUrl;

    @TableField("switch_one")
    @ApiModelProperty(value = "switch_one")
    private Integer switchOne;

    @TableField("switch_two")
    @ApiModelProperty(value = "switch_two")
    private Integer switchTwo;

    @TableField("switch_three")
    @ApiModelProperty(value = "switch_three")
    private Integer switchThree;

    @TableField("switch_four")
    @ApiModelProperty(value = "switch_four")
    private Integer switchFour;

    @TableField("switch_five")
    @ApiModelProperty(value = "switch_five")
    private Integer switchFive;

    @TableField("switch_six")
    @ApiModelProperty(value = "switch_six")
    private Integer switchSix;

    @TableField("switch_seven")
    @ApiModelProperty(value = "switch_seven")
    private Integer switchSeven;

    @TableField("switch_eight")
    @ApiModelProperty(value = "switch_eight")
    private Integer switchEight;

    @TableField("switch_nine")
    @ApiModelProperty(value = "switch_nine")
    private Integer switchNine;

    @TableField("switch_ten")
    @ApiModelProperty(value = "switch_ten")
    private Integer switchTen;

    @TableField("switch_eleven")
    @ApiModelProperty(value = "switch_eleven")
    private Integer switchEleven;

    @TableField("weight_value")
    @ApiModelProperty(value = "weight_value")
    private Integer weightValue;

    @TableField("site_state")
    @ApiModelProperty(value = "site_state")
    private Boolean siteState;

    @TableField("taobao_store_name")
    @ApiModelProperty(value = "taobao_store_name")
    private String taobaoStoreName;

}