package cos.service;

import java.io.IOError;
import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory 인스턴스를 하나 생성하고
 * SqlSession을 반환해주는 유틸클래스
 * 
		sql세션을 쓰고싶을때 session factory를 만드는데, 어플리케이션별로 하나만 존재하는 것이 좋다.
		ession factory를 하나만 만들어서 반환하는 유틸리티클래스 만들자(MyBatisConfig)
 */
public class MyBatisConfig {

	//변수선언 하나만 계속 쓸거니까 static선언
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		//null일 때만 생성하면 팩토리는 1개만 존재시킬수 있다.
		if(sqlSessionFactory == null)
		{
			//mybatis경로 최상위 경로에 있으므로 파일명만 
			String resource = "mybatis-config.xml";
			
			try 
			{
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				/*
				 * Resources : myBatis에서 지원하는 유틸리티 클래스
				 * 
				 */
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		return sqlSessionFactory;
	}
	
}
