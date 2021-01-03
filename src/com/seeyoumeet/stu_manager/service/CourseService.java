package com.seeyoumeet.stu_manager.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.seeyoumeet.stu_manager.dao.IBaseDao;
import com.seeyoumeet.stu_manager.dao.IClazzDao;
import com.seeyoumeet.stu_manager.dao.impl.BaseDaoImpl;
import com.seeyoumeet.stu_manager.dao.impl.ClazzDaoImpl;
import com.seeyoumeet.stu_manager.entity.Clazz;
import com.seeyoumeet.stu_manager.entity.Course;
import com.seeyoumeet.stu_manager.entity.Grade;
import com.seeyoumeet.stu_manager.entity.Page;
import com.seeyoumeet.stu_manager.entity.Student;
import com.seeyoumeet.stu_manager.util.MySQLUtil;
import com.seeyoumeet.stu_manager.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 课程服务层
 * @author bojiangzhou
 *
 */
public class CourseService {
	
	IBaseDao dao = new BaseDaoImpl();
	
	/**
	 * 获取所有课程
	 * @return
	 */
	public String getCourseList(String gradeid){
		List<Object> list;
		if(StringUtil.isEmpty(gradeid)){
			list = dao.getList(Course.class, "SELECT * FROM course");
		} else{
			list = dao.getList(Course.class, 
					"SELECT c.* FROM course c, grade_course gc WHERE c.id=gc.courseid AND gc.gradeid=?", 
					new Object[]{Integer.parseInt(gradeid)});
		}
		//json化
        String result = JSONArray.fromObject(list).toString();
        
        return result;
	}

	/**
	 * 添加课程
	 * @param course
	 */
	public void addCourse(Course course) {
		dao.insert("INSERT INTO course(name) value(?)", new Object[]{course.getName()});
	}

	/**
	 * 删除课程
	 * @param courseid
	 * @throws Exception 
	 */
	public void deleteClazz(int courseid) throws Exception {
		//获取连接
		Connection conn = MySQLUtil.getConnection();
		try {
			//开启事务
			MySQLUtil.startTransaction();
			//删除成绩表
			dao.deleteTransaction(conn, "DELETE FROM escore WHERE courseid=?", new Object[]{courseid});
			//删除班级的课程和老师的关联
			dao.deleteTransaction(conn, "DELETE FROM clazz_course_teacher WHERE courseid=?", new Object[]{courseid});
			//删除年级与课程关联
			dao.deleteTransaction(conn, "DELETE FROM grade_course WHERE courseid=?",  new Object[]{courseid});
			//最后删除课程
			dao.deleteTransaction(conn, "DELETE FROM course WHERE id=?",  new Object[]{courseid});
			
			//提交事务
			MySQLUtil.commit();
		} catch (Exception e) {
			//回滚事务
			MySQLUtil.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			MySQLUtil.closeConnection();
		}
	}
	
	
	
	
}
