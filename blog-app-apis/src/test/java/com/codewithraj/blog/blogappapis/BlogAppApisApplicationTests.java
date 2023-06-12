package com.codewithraj.blog.blogappapis;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.codewithraj.blog.blogappapis.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	public void repoTest(){
		String ClassName = this.userRepo.getClass().getName();
		String packName = this.userRepo.getClass().getPackage().getName();
		System.out.println(ClassName);
		System.out.println(packName);


	}


}
