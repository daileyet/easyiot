package com.openthinks.easyiot.core.mapper;

import com.openthinks.easyiot.core.model.BizRecordData;
import com.openthinks.easyiot.core.model.BizRecordDataExample;
import java.util.List;
import net.sourceforge.orm.mybatis.Page;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;

public interface BizRecordDataMapper {
    long countByExample(BizRecordDataExample example);

    int deleteByExample(BizRecordDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizRecordData record);

    int insertSelective(BizRecordData record);

    List<BizRecordData> selectByExampleWithRowbounds(BizRecordDataExample example, Page<BizRecordData> rowBounds);

    BizRecordData selectOneByExample(BizRecordDataExample example);

    List<BizRecordData> selectByExample(BizRecordDataExample example);

    BizRecordData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizRecordData record, @Param("example") BizRecordDataExample example);

    int updateByExample(@Param("record") BizRecordData record, @Param("example") BizRecordDataExample example);

    int updateByPrimaryKeySelective(BizRecordData record);

    int updateByPrimaryKey(BizRecordData record);

    default BizRecordData selectOneByExampleSafely(BizRecordDataExample example) {
        List<BizRecordData> list=this.selectByExample(example);
        if(list.isEmpty()) return null;
        if(list.size()>1) {LoggerFactory.getLogger(BizRecordDataMapper.class).info("select one retured multiple rows");}
        return list.get(0);
    }

    int insertInBatch(List<BizRecordData> list);
}