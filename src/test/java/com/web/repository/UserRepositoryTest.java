package com.web.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.web.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class UserRepositoryTest {
	
	@Autowired UserRepository repo;

	@Test
	public void test() {
		String name = "Test@" + System.currentTimeMillis();
		
		long count = repo.count();
		
		User user = new User();
		user.setName(name);
		
		user = repo.save(user);
		
		assertEquals(count+1, repo.count());
		assertEquals(name, user.getName());
	}

}
