package test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.UserDao;
import dto.UserDTO;
import factory.DaoFactory;

public class UserDaoText {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		UserDTO user = new UserDTO();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPw("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		UserDTO user2 = dao.get(user.getId());
		System.out.println(user2);
		System.out.println(user2.getId() + " 조회 성공");
	}
}