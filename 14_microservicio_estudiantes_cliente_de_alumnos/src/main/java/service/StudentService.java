package service;

import java.util.List;

import model.Student;

public interface StudentService {
	void altaStudent(Student student);
	List<Student> studentPuntuacionMinima(double puntuacion);
}
