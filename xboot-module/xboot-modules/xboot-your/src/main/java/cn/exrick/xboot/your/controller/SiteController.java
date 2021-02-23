package cn.exrick.xboot.your.controller;


import cn.exrick.xboot.core.base.XbootBaseController;
import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.Site;
import cn.exrick.xboot.your.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 */
@Slf4j
@RestController
@Api(tags = "站点表管理接口")
@RequestMapping("/xboot/site")
@Transactional
public class SiteController extends XbootBaseController<Site, String> {

    @Autowired
    private SiteService siteService;

    @Override
    public SiteService getService() {
        return siteService;
    }

    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<Site>> getByCondition(Site site, SearchVo searchVo, PageVo pageVo) {

        Page<Site> page = siteService.findByCondition(site, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<Site>>().setData(page);
    }
}
