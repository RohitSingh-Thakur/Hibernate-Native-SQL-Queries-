package root;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stdId;
	private String name;
	private int marks;
	private String gender;
	private String bloodGroup;

	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(String name, int marks, String gender, String bloodGroup) {
		this.name = name;
		this.marks = marks;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", name=" + name + ", marks=" + marks + ", gender=" + gender
				+ ", bloodGroup=" + bloodGroup + "]";
	}

}
