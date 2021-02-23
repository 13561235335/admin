package cn.exrick.xboot.your.service;

import cn.exrick.xboot.core.base.XbootBaseService;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.RequestUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 请求用户表接口
 * @author admin
 */
public interface RequestUserService extends XbootBaseService<RequestUser, String> {

    /**
    * 多条件分页获取
    * @param requestUser
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<RequestUser> findByCondition(RequestUser requestUser, SearchVo searchVo, Pageable pageable);

}