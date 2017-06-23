package factory;

import dao.UserDao;
import util.ConnectionMaker;
import util.MyConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new MyConnectionMaker();
	}
}