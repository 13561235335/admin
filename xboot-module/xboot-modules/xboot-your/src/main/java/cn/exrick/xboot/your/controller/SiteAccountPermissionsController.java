package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.SiteAccountPermissions;
import cn.exrick.xboot.your.service.ISiteAccountPermissionsService;
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
@Api(tags = "站点帐号权限管理接口")
@RequestMapping("/xboot/siteAccountPermissions")
@Transactional
public class SiteAccountPermissionsController {

    @Autowired
    private ISiteAccountPermissionsService iSiteAccountPermissionsService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<SiteAccountPermissions> get(@PathVariable String id) {

        SiteAccountPermissions siteAccountPermissions = iSiteAccountPermissionsService.getById(id);
        return new ResultUtil<SiteAccountPermissions>().setData(siteAccountPermissions);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<SiteAccountPermissions>> getAll() {

        List<SiteAccountPermissions> list = iSiteAccountPermissionsService.list();
        return new ResultUtil<List<SiteAccountPermissions>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<SiteAccountPermissions>> getByPage(PageVo page) {

        IPage<SiteAccountPermissions> data = iSiteAccountPermissionsService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<SiteAccountPermissions>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<SiteAccountPermissions> saveOrUpdate(SiteAccountPermissions siteAccountPermissions) {

        if (iSiteAccountPermissionsService.saveOrUpdate(siteAccountPermissions)) {
            return new ResultUtil<SiteAccountPermissions>().setData(siteAccountPermissions);
        }
        return new ResultUtil<SiteAccountPermissions>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iSiteAccountPermissionsService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
