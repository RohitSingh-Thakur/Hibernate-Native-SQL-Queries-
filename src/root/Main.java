package root;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static List<StudentEntity> createStudents() {

		StudentEntity s1 = new StudentEntity("Rohit", 88, "Male", "AB+");
		StudentEntity s2 = new StudentEntity("Mohan", 60, "Male", "B+");
		StudentEntity s3 = new StudentEntity("Mayuri", 58, "Female", "A+");
		StudentEntity s4 = new StudentEntity("Jayesh", 48, "Male", "O+");
		StudentEntity s5 = new StudentEntity("Partik", 72, "Male", "AB+");

		return Arrays.asList(s1, s2, s3, s4, s5);
	}

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(StudentEntity.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			List<StudentEntity> students = createStudents();
			for (StudentEntity student : students) {
				session.save(student);
				session.beginTransaction().commit();
			}

			// Native SQL Query
			SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM StudentEntity WHERE gender = :gender");
			sqlQuery.setParameter("gender", "Male");
			sqlQuery.addEntity(StudentEntity.class);
			List<StudentEntity> list = sqlQuery.list();

			for (StudentEntity entity : list) {
				System.out.println(entity);
			}

			// CRUD OPERATIONS

			// Insert
			SQLQuery insertQuery = session.createSQLQuery(
					"INSERT INTO StudentEntity (name, marks, gender, bloodGroup) VALUES (:name, :marks, :gender, :blood)");
			insertQuery.setParameter("name", "BOB");
			insertQuery.setParameter("marks", 99);
			insertQuery.setParameter("gender", "Male");
			insertQuery.setParameter("blood", "AB-");
			int result = insertQuery.executeUpdate();

			// Update
			SQLQuery updateQuery = session.createSQLQuery("UPDATE StudentEntity SET name = :Name WHERE stdId = :sid");
			updateQuery.setParameter("Name", "Rohit Thakur");
			updateQuery.setParameter("sid", 6);
			int updateResult = updateQuery.executeUpdate();

			// Delete
			SQLQuery deleteQuery = session.createSQLQuery("DELETE FROM StudentEntity WHERE stdId = :sid");
			deleteQuery.setParameter("sid", 6);
			int deleteResult = deleteQuery.executeUpdate();

			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			sessionFactory.close();
		}
	}

}
