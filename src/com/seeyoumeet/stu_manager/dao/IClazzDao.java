package com.seeyoumeet.stu_manager.dao;

import java.util.List;

import com.seeyoumeet.stu_manager.entity.Clazz;
import com.seeyoumeet.stu_manager.entity.Page;

/**
 * 班级数据层接口
 * @author bojiangzhou
 *
 */
public interface IClazzDao extends IBaseDao {
	
	/**
	 * 获取班级详细信息
	 * @param gradeid 年级ID
	 * @param page 分页参数
	 * @return
	 */
	public List<Clazz> getClazzDetailList(String gradeid, Page page);
	
}
