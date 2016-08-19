package br.com.erudio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.mappers.UserMapper;
import br.com.erudio.models.User;
import br.com.erudio.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired private UserMapper userMapper;
    
    @Override
    @Transactional
    public User create(User user) {
    	try {
    		logger.info("Creating a user");
			userMapper.insertUser(user);
		} catch (Exception e) {
			logger.error(e);
		}
		return user;
    }

    @Override
    public User findById(String userId) {
    	logger.info("Finding a user by ID");
    	User user = new User();
		try {
    		logger.info("Finding all users");
    		user = userMapper.findUserById(Integer.valueOf(userId));
		} catch (Exception e) {
			logger.error(e);
		}
        return user;
    }

	@Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
    	try {
    		logger.info("Finding all users");
            users = (ArrayList<User>) userMapper.findAllUsers();
		} catch (Exception e) {
			logger.error(e);
		}
        return users;
    }
    
    @Override
    @Transactional
    public User update(User user) {
    	try {
    		logger.info("Updating a user");
    		userMapper.updateUser(user);
		} catch (Exception e) {
			logger.error(e);
		}
		return user;
    }

    @Override
    @Transactional
    public void delete(User user) {
		try {
			logger.info("Deleting a user");
			userMapper.removeUser(user.getIdUser());
		} catch (Exception ex) {
			logger.error(ex);
		}
    }
}
