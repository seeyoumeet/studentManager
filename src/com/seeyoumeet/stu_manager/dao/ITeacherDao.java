package com.seeyoumeet.stu_manager.dao;

import java.util.List;

import com.seeyoumeet.stu_manager.entity.Clazz;
import com.seeyoumeet.stu_manager.entity.Grade;
import com.seeyoumeet.stu_manager.entity.Teacher;

/**
 * 操作教师的数据层接口
 * @author bojiangzhou
 *
 */
public interface ITeacherDao extends IBaseDao {
	
	/**
	 * 获取教师信息，这里需要将教师所选择的课程查询出来
	 * @param sql
	 * @param param
	 * @param grade 年级参数
	 * @param clazz 班级参数
	 * @return
	 */
	public List<Teacher> getTeacherList(String sql, Object[] param, Grade grade, Clazz clazz);
	
}
