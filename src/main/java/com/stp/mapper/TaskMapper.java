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
    // 执行数据添加语句(动态生成的sql)
    @Insert("${sql}")
    int insertTaskData(String sql);
    // 得到最新的一个task
    @Select("select id,task_keys,task_name from db_label.tb_task order by id desc limit 1")
    Task getNewWestTask();
    // 根据ID得到task
    @Select("select * from db_label.tb_task where id = #{id}")
    Task getTaskById(Integer id);
}
