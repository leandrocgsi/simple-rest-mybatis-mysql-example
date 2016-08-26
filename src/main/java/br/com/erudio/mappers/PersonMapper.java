package br.com.erudio.mappers;

import java.util.List;

import br.com.erudio.models.Person;

public interface PersonMapper {

	Person insertPerson(Person person);
	Person findPersonById(Integer id);
	List<Person> findAllPersons();
	Person updatePerson(Person person);
	void removePerson(Integer idPerson);

}