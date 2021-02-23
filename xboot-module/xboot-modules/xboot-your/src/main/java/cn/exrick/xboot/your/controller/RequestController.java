package cn.exrick.xboot.your.controller;

import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.Result;
import cn.exrick.xboot.your.entity.Site;
import cn.exrick.xboot.your.entity.SiteAccountNumber;

import cn.exrick.xboot.your.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ISiteAccountNumberService siteAccountNumberService;
    @Autowired
    private ISiteService siteService;
    @Autowired
    private ISiteAccountPermissionsService siteAccountPermissionsService;
    @Autowired
    private IRequestUserService requestUserService;
    @Autowired
    private IRecordService recordService;

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

        List<Site> sites = siteService.list();
        if(sites == null && sites.size() == 0){
            return objectResultUtil.setErrorMsg(-1,"解析失败");
        }
        for (Site site1 : sites) {
//            List<SiteAccountNumberJPA> list =  siteAccountNumberService.selectBySite(site.getId(),type);
            List<SiteAccountNumber> list =  siteAccountNumberService.list();
            if(list !=  null && list.size() > 0){
                return objectResultUtil.setSuccessMsg("a");
            }
        }


        return new ResultUtil<String>().setData(null);
    }
}
