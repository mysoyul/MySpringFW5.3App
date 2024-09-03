package myspring.user;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
class DBTest {
	@Autowired
	DataSource dataSource;
	
	@Test
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