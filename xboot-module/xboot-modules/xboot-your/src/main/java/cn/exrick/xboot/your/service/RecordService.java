package cn.exrick.xboot.your.service;

import cn.exrick.xboot.core.base.XbootBaseService;
import cn.exrick.xboot.core.common.vo.SearchVo;
import cn.exrick.xboot.your.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 记录表接口
 * @author admin
 */
public interface RecordService extends XbootBaseService<Record, String> {

    /**
    * 多条件分页获取
    * @param record
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Record> findByCondition(Record record, SearchVo searchVo, Pageable pageable);

}