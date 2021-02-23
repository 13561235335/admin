package cn.exrick.xboot.your.service;

import cn.exrick.xboot.your.dto.SiteAccountDto;
import cn.exrick.xboot.your.entity.Site;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 站点表接口
 * @author lw
 */
public interface ISiteService extends IService<Site> {

    List<SiteAccountDto> getAvailableSiteAccount(String siteType);
}