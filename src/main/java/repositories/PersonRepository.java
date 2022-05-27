package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBConnection;
import model.PersonDB;
import repositories.PersonRepository;

public class PersonRepository {

	private Connection connection;

	public PersonRepository() {
		try {
			this.connection = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<PersonDB> getListPerson() throws SQLException, Exception {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		List<PersonDB> list = new ArrayList<PersonDB>();
		try {
			String sql = "SELECT * FROM crud_struts1.person";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PersonDB person = new PersonDB(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				list.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}

	public PersonDB getPersonById(int id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PersonDB person = null;
		try {
			String sql = "SELECT person.id, person.name, person.age, person.email, person.address FROM crud_struts1.person where person.id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			person = new PersonDB();
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public int createPerson(PersonDB person) throws SQLException, Exception {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			String sql = "INSERT INTO person(name, age, address, email) VALUES (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setString(3, person.getAddress());
			ps.setString(4, person.getEmail());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public int deletePerson(int id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			String sql = "delete from crud_struts1.person where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public int updatePerson(PersonDB person) throws SQLException, Exception {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			String sql = "Update crud_struts1.person SET name=?, age=?, address=?, email=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setString(3, person.getAddress());
			ps.setString(i, person.getEmail());
			ps.setInt(5, person.getId());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
