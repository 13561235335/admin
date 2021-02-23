package cn.exrick.xboot.your.service;

import cn.exrick.xboot.core.base.XbootBaseService;
import cn.exrick.xboot.your.entity.SiteAccountNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.core.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author Exrick
 */
public interface SiteAccountNumberService extends XbootBaseService<SiteAccountNumber, String> {

    /**
    * 多条件分页获取
    * @param siteAccountNumber
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<SiteAccountNumber> findByCondition(SiteAccountNumber siteAccountNumber, SearchVo searchVo, Pageable pageable);

}