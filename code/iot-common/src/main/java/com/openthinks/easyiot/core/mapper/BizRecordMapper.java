package com.openthinks.easyiot.core.mapper;

import com.openthinks.easyiot.core.model.BizRecord;
import com.openthinks.easyiot.core.model.BizRecordExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;

public interface BizRecordMapper {
    long countByExample(BizRecordExample example);

    int deleteByExample(BizRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizRecord record);

    int insertSelective(BizRecord record);

    List<BizRecord> selectByExampleWithBLOBsWithRowbounds(BizRecordExample example, Page<BizRecord> rowBounds);

    BizRecord selectOneByExampleWithBLOBs(BizRecordExample example);

    List<BizRecord> selectByExampleWithBLOBs(BizRecordExample example);

    List<BizRecord> selectByExampleWithRowbounds(BizRecordExample example, Page<BizRecord> rowBounds);

    BizRecord selectOneByExample(BizRecordExample example);

    List<BizRecord> selectByExample(BizRecordExample example);

    BizRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizRecord record, @Param("example") BizRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") BizRecord record, @Param("example") BizRecordExample example);

    int updateByExample(@Param("record") BizRecord record, @Param("example") BizRecordExample example);

    int updateByPrimaryKeySelective(BizRecord record);

    int updateByPrimaryKeyWithBLOBs(BizRecord record);

    int updateByPrimaryKey(BizRecord record);

    default BizRecord selectOneByExampleWithBLOBsSafely(BizRecordExample example) {
        List<BizRecord> list=this.selectByExampleWithBLOBs(example);
        if(list.isEmpty()) return null;
        if(list.size()>1) {LoggerFactory.getLogger(BizRecordMapper.class).info("select one returned {} rows",list.size());}
        return list.get(0);
    }

    default BizRecord selectOneByExampleSafely(BizRecordExample example) {
        List<BizRecord> list=this.selectByExample(example);
        if(list.isEmpty()) return null;
        if(list.size()>1) {LoggerFactory.getLogger(BizRecordMapper.class).info("select one retured {} rows",list.size());}
        return list.get(0);
    }
}