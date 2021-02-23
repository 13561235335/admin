package cn.exrick.xboot.your.serviceimpl;


import cn.exrick.xboot.your.entity.RequestUser;
import cn.exrick.xboot.your.mapper.RequestUserMapper;
import cn.exrick.xboot.your.service.IRequestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求用户表接口实现
 * @author lw
 */
@Slf4j
@Service
@Transactional
public class IRequestUserServiceImpl extends ServiceImpl<RequestUserMapper, RequestUser> implements IRequestUserService {

    @Autowired
    private RequestUserMapper requestUserMapper;
}