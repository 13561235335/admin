package cn.exrick.xboot.your.serviceimpl;


import cn.exrick.xboot.your.entity.SiteAccountNumber;
import cn.exrick.xboot.your.mapper.SiteAccountNumberMapper;
import cn.exrick.xboot.your.service.ISiteAccountNumberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 站点帐号接口实现
 * @author lw
 */
@Slf4j
@Service
@Transactional
public class ISiteAccountNumberServiceImpl extends ServiceImpl<SiteAccountNumberMapper, SiteAccountNumber> implements ISiteAccountNumberService {

    @Autowired
    private SiteAccountNumberMapper siteAccountNumberMapper;
}