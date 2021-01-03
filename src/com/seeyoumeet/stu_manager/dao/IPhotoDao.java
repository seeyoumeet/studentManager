package com.seeyoumeet.stu_manager.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import com.seeyoumeet.stu_manager.entity.User;

/**
 * 上传照片
 * @author bojiangzhou
 *
 */
public interface IPhotoDao {
	
	/**
	 * 插入照片
	 * @param user
	 * @param is
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws Exception 
	 */
	void setPhoto(User user, InputStream is) throws Exception;
	
	/**
	 * 获取照片，返回输入流
	 * @param user
	 * @return
	 */
	InputStream getPhoto(User user);
}
