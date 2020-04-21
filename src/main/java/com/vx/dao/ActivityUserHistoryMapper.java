package com.vx.dao;

import com.vx.model.ActivityUserHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityUserHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActivityUserHistory record);

    ActivityUserHistory selectByPrimaryKey(Long id);

    List<ActivityUserHistory> selectAll();

    int updateByPrimaryKey(ActivityUserHistory record);

    ActivityUserHistory selectByOpenId(@Param("userId")Long id,@Param("activityId") Long activityId, @Param("sonActivityId") Long sonActivityId,@Param("isOk") Boolean isOk);
}