package com.seeyoumeet.stu_manager.dao;

import java.util.List;

import com.seeyoumeet.stu_manager.entity.Exam;

/**
 * 操作学生的数据层接口
 * @author bojiangzhou
 *
 */
public interface IExamDao extends IBaseDao {
	
	/**
	 * 获取考试信息
	 * @param sql 要执行的sql语句
	 * @param param 参数
	 * @return
	 */
	public List<Exam> getExamList(String sql, List<Object> param);
	
}
