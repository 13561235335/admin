package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.base.XbootBaseController;
import cn.exrick.xboot.core.common.utils.PageUtil;
import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.PageVo;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.dao.SiteAccountNumberDao;
import cn.exrick.xboot.your.entity.Record;
import cn.exrick.xboot.your.entity.Site;
import cn.exrick.xboot.your.entity.SiteAccountNumber;
import cn.exrick.xboot.your.entity.SiteAccountPermissions;
import cn.exrick.xboot.your.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Exrick
 */
@Slf4j
@RestController
@Api(tags = "请求")
@RequestMapping("/xboot/request")
@Transactional
public class RequestController {


    @Autowired
    private SiteAccountNumberService siteAccountNumberService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private SiteAccountPermissionsService siteAccountPermissionsService;
    @Autowired
    private RequestUserService requestUserService;
    @Autowired
    private RecordService recordService;

    Map<String, String> siteswiitch = Collections.synchronizedMap(new HashMap<String, String>());

    @RequestMapping(value = "/jiexi", method = RequestMethod.GET)
    @ApiOperation(value = "解析")
    public Result<String> jiexi(SiteAccountNumber siteAccountNumber) {

        ResultUtil<String> objectResultUtil = new ResultUtil<>();
        // 账号权限验证

        //
        Site site = new Site();
        String type = "qian";
        switch(type){
            case "qian" :
                site.setSwitchOne(1);
                break;
            default :
        }

        Stream<Site> siteStream = siteService.findByCondition(site, null, null).get();
        List<Site> collect = siteStream.collect(Collectors.toList());
        if(collect == null && collect.size() == 0){
            return objectResultUtil.setErrorMsg(-1,"解析失败");
        }
        for (Site site1 : collect) {
            List<SiteAccountNumber> list =  siteAccountNumberService.selectBySite(site.getId(),type);
            if(list !=  null && list.size() > 0){
                return objectResultUtil.setSuccessMsg("a");
            }
        }


        return new ResultUtil<String>().setData(null);
    }
}
