package myspring.user;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
class DBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	void service() {
		UserVO user = userService.getUser("dooly");
		assertEquals("둘리", user.getName());
	}
	
	
	@Test @Disabled
	void mapper() {
		UserVO user = userMapper.selectUserById("dooly");
		System.out.println(user);
		assertEquals("둘리", user.getName());
	}
	
	
	@Test @Disabled
	void mybatis() {
		System.out.println(sessionFactory);
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	
	@Test @Disabled
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB URL = " + metaData.getURL());
			System.out.println("DB Username =" + metaData.getUserName());
			System.out.println("DB Product =" + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}