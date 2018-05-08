package cos.service;

import java.io.IOError;
import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory �ν��Ͻ��� �ϳ� �����ϰ�
 * SqlSession�� ��ȯ���ִ� ��ƿŬ����
 * 
		sql������ ��������� session factory�� ����µ�, ���ø����̼Ǻ��� �ϳ��� �����ϴ� ���� ����.
		ession factory�� �ϳ��� ���� ��ȯ�ϴ� ��ƿ��ƼŬ���� ������(MyBatisConfig)
 */
public class MyBatisConfig {

	//�������� �ϳ��� ��� ���Ŵϱ� static����
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		//null�� ���� �����ϸ� ���丮�� 1���� �����ų�� �ִ�.
		if(sqlSessionFactory == null)
		{
			//mybatis��� �ֻ��� ��ο� �����Ƿ� ���ϸ� 
			String resource = "mybatis-config.xml";
			
			try 
			{
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				/*
				 * Resources : myBatis���� �����ϴ� ��ƿ��Ƽ Ŭ����
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
