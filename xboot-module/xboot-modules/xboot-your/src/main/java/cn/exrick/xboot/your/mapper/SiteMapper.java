package cn.exrick.xboot.your.mapper;

import cn.exrick.xboot.your.dto.SiteAccountDto;
import cn.exrick.xboot.your.entity.Site;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 站点表数据处理层
 * @author lw
 */
public interface SiteMapper extends BaseMapper<Site> {

    List<SiteAccountDto> getAvailableSiteAccount(String siteType, int value);
}