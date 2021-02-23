package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.base.XbootBaseController;
import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.SiteAccountNumber;
import cn.exrick.xboot.your.service.SiteAccountNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Exrick
 */
@Slf4j
@RestController
@Api(tags = "测试管理接口")
@RequestMapping("/xboot/siteAccountNumber")
@Transactional
public class SiteAccountNumberController extends XbootBaseController<SiteAccountNumber, String> {

    @Autowired
    private SiteAccountNumberService siteAccountNumberService;

    @Override
    public SiteAccountNumberService getService() {
        return siteAccountNumberService;
    }

    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<SiteAccountNumber>> getByCondition(SiteAccountNumber siteAccountNumber, SearchVo searchVo, PageVo pageVo) {

        Page<SiteAccountNumber> page = siteAccountNumberService.findByCondition(siteAccountNumber, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<SiteAccountNumber>>().setData(page);
    }
}
