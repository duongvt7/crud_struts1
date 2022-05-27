package services;

import java.sql.SQLException;
import java.util.List;

import model.PersonDB;
import repositories.PersonRepository;

public class PersonService {

	private PersonRepository personRepository;

	public PersonService() {
		personRepository = new PersonRepository();
	}

	public List<PersonDB> getListPerson() throws SQLException, Exception {
		return personRepository.getListPerson();
	}

	public PersonDB getPersonById(int id) throws SQLException, Exception {
		return personRepository.getPersonById(id);
	}

	public int createPerson(PersonDB person) {
		try {
			return personRepository.createPerson(person);
		} catch (Exception ex) {
			return -1;
		}
	}

	public int deletePerson(int id) {
		try {
			return personRepository.deletePerson(id);
		} catch (Exception ex) {
			return -1;
		}
	}

	public int updatePerson(PersonDB person) {
		try {
			return personRepository.updatePerson(person);
		} catch (Exception ex) {
			return -1;
		}
	}
}
