package com.seeyoumeet.stu_manager.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seeyoumeet.stu_manager.dao.IPhotoDao;
import com.seeyoumeet.stu_manager.entity.User;
import com.seeyoumeet.stu_manager.util.MySQLUtil;

public class PhotoDaoImpl implements IPhotoDao {

	public void setPhoto(User user, InputStream is) throws Exception {
		Connection conn = MySQLUtil.getConnection();
		String sql = "";
		if(user.getType() == User.USER_STUDENT){ //学生
			sql = "UPDATE student SET photo=? WHERE number=?";
		} else if(user.getType() == User.USER_TEACHER){ //老师
			sql = "UPDATE teacher SET photo=? WHERE number=?";
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBinaryStream(1, is, is.available());
		ps.setString(2, user.getAccount());
		ps.execute();
		
		MySQLUtil.close(ps);
		MySQLUtil.closeConnection();
	}

	public InputStream getPhoto(User user) {
		Connection conn = MySQLUtil.getConnection();
		InputStream is = null;
		String sql = "";
		if(user.getType() == User.USER_STUDENT){ //学生
			sql = "SELECT photo FROM student WHERE number=?";
		} else if(user.getType() == User.USER_TEACHER){ //老师
			sql = "SELECT photo FROM teacher WHERE number=?";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				is = rs.getBinaryStream(1);
			}
			MySQLUtil.close(ps);
			MySQLUtil.close(rs);
			MySQLUtil.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
	
}
