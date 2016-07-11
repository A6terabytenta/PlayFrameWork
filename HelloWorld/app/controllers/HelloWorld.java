package controllers;

import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class HelloWorld extends Controller {

	static Form<Student> studentForm = Form.form(Student.class);

	public static Result helloworld() {
		return ok("Hello World!");
	}

	public static Result students() {
		return ok(views.html.helloworld.render(Student.all(), studentForm));
	}

	public static Result newStudent() {
		Form<Student> filledForm = studentForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.helloworld.render(Student.all(), filledForm));
		} else {
			Student.create(filledForm.get());
			return redirect(routes.HelloWorld.students());
		}
	}

	public static Result deleteStudent(Long id) {
		Student.delete(id);
		return redirect(routes.HelloWorld.students());
	}
}
