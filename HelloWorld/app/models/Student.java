package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

public class Student extends Model {

	private static final long serialVersionUID = 355886702589780244L;

	public Long id;

	@Required
	@MaxLength(15)
	public String name;

	public Student() {
		super();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Finder<Long, Student> find = new Finder(Long.class, Student.class);

	public Student(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static List<Student> all() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1L, "Nguyen Tuan Anh"));
		students.add(new Student(2L, "Phan Xuan Manh"));
		students.add(new Student(3L, "Vo Tan Loc"));
		return students;
	}

	public static void create(Student student) {
		student.save();
	}

	public static void delete(Long id) {
		 find.ref(id).delete();
	}

}
