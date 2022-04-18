package com.RTM.services.authentication;

import com.RTM.services.authentication.domain.exception.UserNotFoundException;
import com.RTM.services.authentication.domain.service.UserDetailsService;
import com.RTM.services.authentication.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class AuthenticationApplicationTests {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Test
	void loadUserByUsername_TestService() {
		UserDetails user = userDetailsService.loadUserByUsername("admin");
		assertEquals("Comparacion usuario admin","admin",user.getUsername());
	}

	@Test
	void checkPassword() {
		try {
			assertTrue("Contraseña erronea",userService.matchUserPassword(2,"carlosbello"));
		} catch (UserNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
