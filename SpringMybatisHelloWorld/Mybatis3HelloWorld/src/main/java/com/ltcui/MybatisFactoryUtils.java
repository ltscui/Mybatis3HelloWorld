package com.ltcui;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisFactoryUtils {
	private static Logger logger = LoggerFactory.getLogger(MybatisFactoryUtils.class);
	private static SqlSessionFactory factory = null;
	
	/**
	 * 单例模式 获取 SqlSessionFactory 对象
	 * 
	 * @return 
	 */
	public static SqlSessionFactory getSessionFactory() {
		if(MybatisFactoryUtils.factory == null){
			synchronized(MybatisFactoryUtils.class){
				if(MybatisFactoryUtils.factory == null){
					InputStream inputStream = null;
					try {
						inputStream = Resources.getResourceAsStream("mybatis-config.xml");
					} catch (IOException e) {
						logger.error(e.getMessage());
						e.printStackTrace();
					}
					MybatisFactoryUtils.factory = new SqlSessionFactoryBuilder().build(inputStream);
				}
			}
		}
		logger.info(MybatisFactoryUtils.factory + "");
		return MybatisFactoryUtils.factory;
	}
}
