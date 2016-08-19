package br.com.erudio.web.controllers;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.erudio.models.User;
import br.com.erudio.services.UserService;

@Api(value = "user")
@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Find user by ID" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable(value = "userId") String userId){
        User user = userService.findById(userId);
        addHATEOASSupport(user, userId);
		return user;
    }
	
	@ApiOperation(value = "Find all users" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll(){
		List<User> users = userService.findAll();
		ArrayList<User> usersReturn = new ArrayList<User>();
		for (User user : users) {
			String idUser = user.getIdUser().toString();
			addHATEOASSupport(user, idUser);
			usersReturn.add(user);
		}
		return users;
	}
	
	@ApiOperation(value = "Create a new user" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User user){
		User createdUser = userService.create(user);
		/*String idUser = createdUser.getIdUser().toString();
		addHATEOASSupport(createdUser, idUser);*/
		return createdUser;
	}
	
	@ApiOperation(value = "Update an existing user")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public User update(@RequestBody User user){
		User updatedUser = userService.update(user);
		String idUser = updatedUser.getIdUser().toString();
		addHATEOASSupport(updatedUser, idUser);		
		return updatedUser;
	}

	@ApiOperation(value = "Delete user by ID" )
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "userId") String userId){
		User user = userService.findById(userId);
        userService.delete(user);
    }

	private void addHATEOASSupport(User user, String idUser) {
		//user.add(linkTo(methodOn(UserController.class).get(idUser)).withSelfRel());
	}
}
