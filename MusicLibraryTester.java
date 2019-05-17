import org.junit.Test;
import static org.junit.Assert.*;

public class ClassRosterTester {
    private RosterManager manager;
    private Course course1 = new Course("CS56", "Advance Applications Programming");
    private Course course2 = new Course("CS32", "Object Oriented Design and Implementation");

    @Test
	public void testAddCourse() throws CourseLimitException, DuplicateCourseException{
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.addCourse(course2);
        Course[] courseArray = manager.getCourseArray();
        Course[] expected = {course1, course2, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, courseArray);
    }

    @Test
	public void testDeleteCourse() throws CourseLimitException, DuplicateCourseException, CourseNotFoundException, EmptyCourseListException{
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.addCourse(course2);
        manager.deleteCourse("CS56");
        Course[] courseArray = manager.getCourseArray();
        Course[] expected = {course2, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, courseArray);
        manager.deleteCourse("CS32");
        courseArray = manager.getCourseArray();
        Course [] expected2 = {null, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected2, courseArray);
    }


    @Test (expected = CourseNotFoundException.class)
	public void testDeleteCourseNotFound() throws CourseLimitException, DuplicateCourseException, CourseNotFoundException, EmptyCourseListException{
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.addCourse(course2);
        manager.deleteCourse("CS56");
        manager.deleteCourse("CS48");
    }

    @Test (expected = DuplicateCourseException.class)
	public void testDuplicateCourseException()throws CourseLimitException, DuplicateCourseException {
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.addCourse(course1);
    }

    @Test (expected = CourseLimitException.class)
	public void testCourseLimitException() throws CourseLimitException, DuplicateCourseException {
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.addCourse(course2);
        manager.addCourse(new Course("randCourse3", "rand"));
        manager.addCourse(new Course("randCourse4", "rand"));
        manager.addCourse(new Course("randCourse5", "rand"));
        manager.addCourse(new Course("randCourse6", "rand"));
        manager.addCourse(new Course("randCourse7", "rand"));
        manager.addCourse(new Course("randCourse8", "rand"));
        manager.addCourse(new Course("randCourse9", "rand"));
        manager.addCourse(new Course("randCourse10", "rand"));
        manager.addCourse(new Course("randCourse11", "Over Course Limit"));
    }

    @Test (expected = EmptyCourseListException.class)
	public void testDeleteEmptyCourseList() throws CourseNotFoundException, EmptyCourseListException {
        manager = new RosterManager();
        manager.deleteCourse("CS56");
    }

    @Test
	public void testAddStudent() throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS56", student1);
        Student[] studentArray = manager.getCourseArray()[0].getStudentArray();
        Student[] expected = new Student[50];
        expected[0] = student1;
        assertArrayEquals(expected, studentArray);

        Student student2 =  new Student("Richert", "Wang", 12345679);
        Student student3 = new Student("John", "Doe", 11111111);
        Student student4 = new Student("Jane", "Doe", 22222222);
        manager.addStudent("CS56", student2);
        manager.addStudent("CS56", student3);
        manager.addStudent("CS56", student4);

        expected[0] = student3;
        expected[1] = student4;
        expected[2] = student1;
        expected[3] = student2;
        studentArray = manager.getCourseArray()[0].getStudentArray();
        assertArrayEquals(expected, studentArray);
    }

    @Test (expected = StudentLimitException.class)
	public void testAddStudentStudentLimit() throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        for(int i = 0; i <= 50; i++) {
            Student student1 = new Student("Richert","Wang",11111111 + i);
            manager.addStudent("CS56", student1);
        }
    }


    @Test (expected = DuplicateStudentException.class)
	public void testDuplicateStudent() throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS56", student1);
        manager.addStudent("CS56", student1);
    }

    @Test (expected = DuplicateStudentException.class)
	public void testAddStudentDuplicate() throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS56", student1);
        manager.addStudent("CS56", student1);
    }

    @Test (expected = CourseNotFoundException.class)
	public void testAddStudentCourseNotFound()throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException{
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS32", student1);
    }

    @Test
	public void testDeleteStudent() throws EmptyStudentListException, StudentNotFoundException, StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        Student student2 = new Student("DRichert", "Wang", 12345679);
        Student student3 = new Student("DiffRichert", "DiffWang", 11111111);
        manager.addStudent("CS56", student1);
        manager.addStudent("CS56", student2);
        manager.addStudent("CS56", student3);
        manager.deleteStudent(12345679, "CS56");
        Student[] studentArray = manager.getCourseArray()[0].getStudentArray();
        Student[] expected = new Student[50];
        expected[0] = student3;
        expected[1] = student1;
        assertArrayEquals(expected, studentArray);
    }

    @Test (expected = CourseNotFoundException.class)
	public void testDeleteStudentCourseNotFound()throws EmptyStudentListException, StudentNotFoundException, StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS56", student1);
        manager.deleteStudent(12345678, "CS32");
    }

    @Test (expected = EmptyStudentListException.class)
	public void testDeleteStudentEmptyStudentList()throws EmptyStudentListException, StudentNotFoundException, CourseNotFoundException, DuplicateCourseException, CourseLimitException{
        manager = new RosterManager();
        manager.addCourse(course1);
        manager.deleteStudent(12345678, "CS56");
    }

    @Test (expected = StudentNotFoundException.class)
	public void testDeleteStudentStudentNotFound()throws EmptyStudentListException, StudentNotFoundException, StudentLimitException, DuplicateStudentException, CourseNotFoundException, DuplicateCourseException, CourseLimitException{
        manager = new RosterManager();
        manager.addCourse(course1);
        Student student1 = new Student("Richert", "Wang", 12345678);
        manager.addStudent("CS56", student1);
        manager.deleteStudent(12345679, "CS56");
    }
}