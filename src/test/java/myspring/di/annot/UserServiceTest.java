package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.user.di.annot.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	void testUserService() {
		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		assertNotNull(userService.getSecurityService());
		assertTrue(userService.registerUser("U001", "홍길동", "pw1234"));
		assertFalse(userService.registerUser("U002", "김철수", null));
		assertFalse(userService.registerUser("U003", "이영희", ""));
		
	}
}
