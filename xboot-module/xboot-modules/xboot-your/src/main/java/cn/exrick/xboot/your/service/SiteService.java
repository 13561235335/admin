package cn.exrick.xboot.your.service;

import cn.exrick.xboot.core.base.XbootBaseService;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 站点表接口
 * @author admin
 */
public interface SiteService extends XbootBaseService<Site, String> {

    /**
    * 多条件分页获取
    * @param site
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Site> findByCondition(Site site, SearchVo searchVo, Pageable pageable);

}