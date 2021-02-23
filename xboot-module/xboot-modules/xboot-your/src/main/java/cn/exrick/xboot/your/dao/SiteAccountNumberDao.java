 package cn.exrick.xboot.your.dao;

import cn.exrick.xboot.core.base.XbootBaseDao;
import cn.exrick.xboot.your.entity.SiteAccountNumber;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 测试数据处理层
 * @author Exrick
 */
public interface SiteAccountNumberDao extends XbootBaseDao<SiteAccountNumber, String> {

    @Query("select a.id from SiteAccountNumber a,SiteAccountPermissions b where a.id = b.siteAccountId and a.siteId = :1 and a.state = 1 and b.type = :2 and b.state = 1")
    List<SiteAccountNumber> selectBySite(String siteId,String type);
}