package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.UserDao;
import factory.DaoFactory;

public class ApplicationContextIdenticalTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);
		
		System.out.println(dao3);
		System.out.println(dao4);
	}
}