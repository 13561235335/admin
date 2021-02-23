package cn.exrick.xboot.your.service;

import cn.exrick.xboot.core.base.XbootBaseService;
import cn.exrick.xboot.your.entity.SiteAccountPermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.core.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author Exrick
 */
public interface SiteAccountPermissionsService extends XbootBaseService<SiteAccountPermissions, String> {

    /**
    * 多条件分页获取
    * @param siteAccountPermissions
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<SiteAccountPermissions> findByCondition(SiteAccountPermissions siteAccountPermissions, SearchVo searchVo, Pageable pageable);

}