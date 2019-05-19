package base.toy.project;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class mysqlDBTest {

	@Test
	public void testConnection() throws ClassNotFoundException {	
		 Class.forName("org.mariadb.jdbc.Driver");
	    try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/test", "test", "1234"))
		{
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
