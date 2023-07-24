package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Test
    public void createStudentService() {

        studentService.createStudent("Chad", "Darby", "chad.darby@test.com");

//        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@test.com");
//
//        assertEquals("chad.darby@test.com", student.getEmailAddress(), "find by email");
    }

}
