package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.SiteAccountNumber;
import cn.exrick.xboot.your.service.ISiteAccountNumberService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lw
 */
@Slf4j
@RestController
@Api(tags = "站点帐号管理接口")
@RequestMapping("/xboot/siteAccountNumber")
@Transactional
public class SiteAccountNumberController {

    @Autowired
    private ISiteAccountNumberService iSiteAccountNumberService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<SiteAccountNumber> get(@PathVariable String id) {

        SiteAccountNumber siteAccountNumber = iSiteAccountNumberService.getById(id);
        return new ResultUtil<SiteAccountNumber>().setData(siteAccountNumber);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<SiteAccountNumber>> getAll() {

        List<SiteAccountNumber> list = iSiteAccountNumberService.list();
        return new ResultUtil<List<SiteAccountNumber>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<SiteAccountNumber>> getByPage(PageVo page) {

        IPage<SiteAccountNumber> data = iSiteAccountNumberService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<SiteAccountNumber>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<SiteAccountNumber> saveOrUpdate(SiteAccountNumber siteAccountNumber) {

        if (iSiteAccountNumberService.saveOrUpdate(siteAccountNumber)) {
            return new ResultUtil<SiteAccountNumber>().setData(siteAccountNumber);
        }
        return new ResultUtil<SiteAccountNumber>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iSiteAccountNumberService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
