package com.ltcui.student.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ltcui.MybatisFactoryUtils;
import com.ltcui.student.Student;
import com.ltcui.student.dao.StudentMapper;

public class StudentServices {

	/**
	 * 根据学生ID查询学生
	 * 
	 * @param stuId 学生ID
	 * @return 学生对象
	 */
	public Student getStudentById(String stuId) {
		// 获取 SqlSessionFactory 
		SqlSessionFactory sqlSessionFalctory = MybatisFactoryUtils.getSessionFactory();
		SqlSession sqlSession = sqlSessionFalctory.openSession();
		// 此处需要注意 StudentMapper类的路径 需要与 studentMapper.xml配置文件里面的namespace一致 否则会报错误
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.getStudentById(stuId);
		sqlSession.close();
		
		return student ;
	}
}
