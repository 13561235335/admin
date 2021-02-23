package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.Site;
import cn.exrick.xboot.your.service.ISiteService;
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
@Api(tags = "站点表管理接口")
@RequestMapping("/xboot/site")
@Transactional
public class SiteController {

    @Autowired
    private ISiteService iSiteService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<Site> get(@PathVariable String id) {

        Site site = iSiteService.getById(id);
        return new ResultUtil<Site>().setData(site);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<Site>> getAll() {

        List<Site> list = iSiteService.list();
        return new ResultUtil<List<Site>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<Site>> getByPage(PageVo page) {

        IPage<Site> data = iSiteService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<Site>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<Site> saveOrUpdate(Site site) {

        if (iSiteService.saveOrUpdate(site)) {
            return new ResultUtil<Site>().setData(site);
        }
        return new ResultUtil<Site>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iSiteService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
