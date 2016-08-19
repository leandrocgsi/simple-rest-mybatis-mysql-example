/*package br.com.erudio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
    @PersistenceContext
    protected EntityManager entityManager;
    
    @Override
    @Transactional
    public Person create(Person person) {
    	try {
    		logger.info("Creating a person");
			person = entityManager.merge(person);
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    public Person findById(String personId) {
    	logger.info("Finding a person by ID");
    	Person person = new Person();
		try {
    		logger.info("Finding all persons");
    		person = entityManager.find(Person.class, Long.parseLong(personId));
		} catch (Exception e) {
			logger.error(e);
		}
        return person;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Person> findAll() {
        ArrayList<Person> persons = new ArrayList<>();
    	try {
    		logger.info("Finding all persons");
            Query query = entityManager.createQuery("from Person p");
            persons = (ArrayList<Person>) query.getResultList();
		} catch (Exception e) {
			logger.error(e);
		}
        return persons;
    }
    
    @Override
    @Transactional
    public Person update(Person person) {
    	try {
    		logger.info("Updating a person");
			person = entityManager.merge(person);
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    @Transactional
    public void delete(Person person) {
		try {
			logger.info("Deleting a person");
			entityManager.remove(person);
		} catch (Exception ex) {
			logger.error(ex);
		}
    }
}
*/