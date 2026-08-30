package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudnetSpringTest {
	
	@Resource(name = "javaCourse")
	Course course;
	
	@Autowired
	@Qualifier("gradeService")
	GradeService gradeService;
	
	@Test
	void testCourse() {
		assertNotNull(course);
		assertEquals("C001", course.getCourseId());
		assertEquals("자바 프로그래밍", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		assertEquals("홍길동", course.getStudents().get(0).getName());
		assertEquals(85.0, course.getAverageScore());
	}
	
	@Test
	void testGradeService() {
		assertNotNull(gradeService);
		assertNotNull(gradeService.getCourse());
		
		List<Student> high = gradeService.getHighScoreStudents(80);
		assertEquals(2,high.size());
		
		assertEquals("A", gradeService.calculateGrade("S001"));
		assertEquals("B", gradeService.calculateGrade("S002"));
		assertEquals("C", gradeService.calculateGrade("S003"));
		assertEquals("학생을 찾을 수 없습니다.", gradeService.calculateGrade("S999"));
	}

}
