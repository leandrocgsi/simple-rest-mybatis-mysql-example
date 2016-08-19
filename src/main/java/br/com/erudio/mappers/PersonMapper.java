package br.com.erudio.mappers;

import java.util.List;

import br.com.erudio.models.Person;

public interface PersonMapper {

	void insertPerson(Person person);
	Person findPersonById(Integer id);
	List<Person> findAllPersons();
	void updatePerson(Person person);
	void removePerson(Integer idPerson);

}