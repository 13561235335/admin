package cn.exrick.xboot.your.serviceimpl;


import cn.exrick.xboot.your.entity.Record;
import cn.exrick.xboot.your.mapper.RecordMapper;
import cn.exrick.xboot.your.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 记录表接口实现
 * @author lw
 */
@Slf4j
@Service
@Transactional
public class IRecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;
}