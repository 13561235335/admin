package cn.exrick.xboot.your.serviceimpl;


import cn.exrick.xboot.your.entity.SiteAccountPermissions;
import cn.exrick.xboot.your.mapper.SiteAccountPermissionsMapper;
import cn.exrick.xboot.your.service.ISiteAccountPermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 站点帐号权限接口实现
 * @author lw
 */
@Slf4j
@Service
@Transactional
public class ISiteAccountPermissionsServiceImpl extends ServiceImpl<SiteAccountPermissionsMapper, SiteAccountPermissions> implements ISiteAccountPermissionsService {

    @Autowired
    private SiteAccountPermissionsMapper siteAccountPermissionsMapper;
}