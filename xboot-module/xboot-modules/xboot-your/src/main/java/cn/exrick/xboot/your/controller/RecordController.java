package cn.exrick.xboot.your.controller;


import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.Record;
import cn.exrick.xboot.your.service.IRecordService;
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
@Api(tags = "记录表管理接口")
@RequestMapping("/xboot/record")
@Transactional
public class RecordController {

    @Autowired
    private IRecordService iRecordService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<Record> get(@PathVariable String id) {

        Record record = iRecordService.getById(id);
        return new ResultUtil<Record>().setData(record);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<Record>> getAll() {

        List<Record> list = iRecordService.list();
        return new ResultUtil<List<Record>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<Record>> getByPage(PageVo page) {

        IPage<Record> data = iRecordService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<Record>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<Record> saveOrUpdate(Record record) {

        if (iRecordService.saveOrUpdate(record)) {
            return new ResultUtil<Record>().setData(record);
        }
        return new ResultUtil<Record>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iRecordService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
