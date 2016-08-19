package br.com.erudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;

import br.com.erudio.mappers.UserMapper;
import br.com.erudio.models.User;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests
{

	@Autowired private UserMapper userMapper;
	@Autowired private SpringSwaggerConfig swaggerConfig;
	//@Autowired private UserAnnotationMapper userMapper;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findUserById()  {
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new User(0, "Siva", "siva@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getIdUser());
		assertEquals("Siva", newUser.getName());
		assertEquals("siva@gmail.com", newUser.getEmail());
	}
}
