package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.RequestUser;
import cn.exrick.xboot.your.service.IRequestUserService;
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
@Api(tags = "请求用户表管理接口")
@RequestMapping("/xboot/requestUser")
@Transactional
public class RequestUserController {

    @Autowired
    private IRequestUserService iRequestUserService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<RequestUser> get(@PathVariable String id) {

        RequestUser requestUser = iRequestUserService.getById(id);
        return new ResultUtil<RequestUser>().setData(requestUser);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<RequestUser>> getAll() {

        List<RequestUser> list = iRequestUserService.list();
        return new ResultUtil<List<RequestUser>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<RequestUser>> getByPage(PageVo page) {

        IPage<RequestUser> data = iRequestUserService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<RequestUser>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<RequestUser> saveOrUpdate(RequestUser requestUser) {

        if (iRequestUserService.saveOrUpdate(requestUser)) {
            return new ResultUtil<RequestUser>().setData(requestUser);
        }
        return new ResultUtil<RequestUser>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iRequestUserService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
