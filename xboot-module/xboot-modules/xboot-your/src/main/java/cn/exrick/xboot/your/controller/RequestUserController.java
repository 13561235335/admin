package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.base.XbootBaseController;
import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.RequestUser;
import cn.exrick.xboot.your.service.RequestUserService;
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
@Api(tags = "请求用户表管理接口")
@RequestMapping("/xboot/requestUser")
@Transactional
public class RequestUserController extends XbootBaseController<RequestUser, String> {

    @Autowired
    private RequestUserService requestUserService;

    @Override
    public RequestUserService getService() {
        return requestUserService;
    }

    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<RequestUser>> getByCondition(RequestUser requestUser, SearchVo searchVo, PageVo pageVo) {

        Page<RequestUser> page = requestUserService.findByCondition(requestUser, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<RequestUser>>().setData(page);
    }
}
