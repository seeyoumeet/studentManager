package com.seeyoumeet.stu_manager.dao;

import java.util.List;

import com.seeyoumeet.stu_manager.entity.Page;
import com.seeyoumeet.stu_manager.entity.Student;

/**
 * 操作学生的数据层接口
 * @author bojiangzhou
 *
 */
public interface IStudentDao extends IBaseDao {
	
	/**
	 * 获取学生信息，这里需要将学生的班级，年级等信息封装进去
	 * @param sql 要执行的sql语句
	 * @param param 参数
	 * @return
	 */
	public List<Student> getStudentList(String sql, List<Object> param);
	
}
