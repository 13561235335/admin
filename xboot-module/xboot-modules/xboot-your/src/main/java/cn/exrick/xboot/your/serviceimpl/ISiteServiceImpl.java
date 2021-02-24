package cn.exrick.xboot.your.serviceimpl;


import cn.exrick.xboot.your.dto.SiteAccountDto;
import cn.exrick.xboot.your.entity.Site;
import cn.exrick.xboot.your.mapper.SiteMapper;
import cn.exrick.xboot.your.service.ISiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 站点表接口实现
 * @author lw
 */
@Slf4j
@Service
@Transactional
public class ISiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public List<SiteAccountDto> getAvailableSiteAccount(String siteType) {

        return siteMapper.getAvailableSiteAccount(siteType);
    }
}