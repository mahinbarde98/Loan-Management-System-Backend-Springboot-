package com.cts.management;

import com.cts.management.dao.LoanDao;
import com.cts.management.dao.UserDao;
import com.cts.management.entity.Loan;
import com.cts.management.entity.Role;
import com.cts.management.entity.User;
import com.cts.management.service.LoanService;
import com.cts.management.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ManagementApplicationTests {
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	Loan loan = new Loan(1,"mahesh","barde",true,12.2f,"spur");


	@Test
	void contextLoads() {
	}
	@Test
	void add(){
		loanDao.save(loan);
		Set<Role> role=new HashSet<Role>();
		role.add(new Role("User","Default user"));

		String password=userService.getEncodedPassword("mahesh@123");
		User user =new User("mahesh123","mahesh","barde",password,role);

		userDao.save(user);


	}


}
