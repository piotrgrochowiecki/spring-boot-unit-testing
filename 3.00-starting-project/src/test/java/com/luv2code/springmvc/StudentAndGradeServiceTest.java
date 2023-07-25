package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setupDataBase() {
        jdbcTemplate.execute("INSERT INTO student(id, firstname, lastname, email_address) VALUES (1, 'Eric', 'Roby', 'eric.roby@test.com')");
    }

    @AfterEach
    public void setupAfterTransaction() {
        jdbcTemplate.execute("DELETE FROM student");
    }

    @Test
    public void createStudentService() {

        studentService.createStudent("Chad", "Darby", "chad.darby@test.com");

        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@test.com");

        assertEquals("chad.darby@test.com", student.getEmailAddress(), "find by email");
    }

    @Test
    public void isStudentNullCheck() {

        assertTrue(studentService.checkIfStudentIsNull(1));

        assertFalse(studentService.checkIfStudentIsNull(0));
    }

    @Test
    public void deleteStudentService() {
        Optional<CollegeStudent> deletedCollegeStudent = studentDao.findById(1);

        assertTrue(deletedCollegeStudent.isPresent());

        studentService.deleteStudent(1);

        deletedCollegeStudent = studentDao.findById(1);

        assertFalse(deletedCollegeStudent.isPresent());
    }


    @Test
    @Sql("/sampleData.sql")
    public void getGradeBookService() {
        Iterable<CollegeStudent> collegeStudentIterable = studentService.getGradebook();

        List<CollegeStudent> collegeStudentsList = new ArrayList<>();

        collegeStudentIterable.forEach(collegeStudent -> collegeStudentsList.add(collegeStudent));

        assertEquals(6, collegeStudentsList.size());
    }
}
