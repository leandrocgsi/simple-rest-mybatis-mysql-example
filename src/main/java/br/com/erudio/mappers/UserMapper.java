package br.com.erudio.mappers;

import java.util.List;

import br.com.erudio.models.User;

public interface UserMapper {

	void insertUser(User user);
	User findUserById(Integer id);
	List<User> findAllUsers();
	void updateUser(User user);
	void removeUser(Integer idUser);

}