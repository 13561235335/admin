package cn.exrick.xboot.your.entity;


import cn.exrick.xboot.core.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author admin
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "record")
@TableName("record")
@ApiModel(value = "记录表")
public class Record extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("site_id")
    @ApiModelProperty(value = "site_id")
    private String siteId;

    @TableField("site_account_id")
    @ApiModelProperty(value = "site_account_id")
    private String siteAccountId;

    @TableField("request_user_id")
    @ApiModelProperty(value = "request_user_id")
    private String requestUserId;

    @TableField("type")
    @ApiModelProperty(value = "type")
    private Integer type;

    @TableField("count_time")
    @ApiModelProperty(value = "count_time")
    private String countTime;

    @TableField("request_address")
    @ApiModelProperty(value = "request_address")
    private String requestAddress;

    @TableField("file_address")
    @ApiModelProperty(value = "file_address")
    private String fileAddress;

    @TableField("analysis_method")
    @ApiModelProperty(value = "analysis_method")
    private String analysisMethod;


}