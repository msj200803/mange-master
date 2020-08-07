package com.stp.mapper;

import com.stp.entity.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TaskMapper {
    //添加任务到任务中心
    @Insert("insert into db_label.tb_task values(0,#{taskName},#{taskKeys},#{taskCreatUserId},#{taskAuthority},#{taskFileUrl},now(),now(),#{taskTag})")
    int insertTask(Task task);
    //执行sql建表语句
    @Update("${sql}")
    int createTable(String sql);
    @Select("select id,task_keys from admin.tb_task order by create_time desc limit 0,1")
    Task getNewWestTask();
}
