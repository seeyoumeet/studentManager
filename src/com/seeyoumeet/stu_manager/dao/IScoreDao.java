package com.seeyoumeet.stu_manager.dao;

import java.util.List;
import java.util.Map;

import com.seeyoumeet.stu_manager.entity.Exam;


/**
 * 操作成绩的数据层接口
 * @author bojiangzhou
 *
 */
public interface IScoreDao extends IBaseDao {
	
	/**
	 * 获取学生成绩表
	 * @param exam
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getScoreList(Exam exam);
	
}
