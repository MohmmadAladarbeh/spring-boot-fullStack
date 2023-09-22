package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @DataJpaTest: we use it because we want to test repository
 * */
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;



    @BeforeEach
    void saveStudent () {
        Student student = new Student(
                "Mohammad",
                "mohmad@gmail.com",
                Gender.FEMALE
        );
        studentRepository.save(student);
    }

    @AfterEach
    void deleteStudent () {
        studentRepository.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentExistsEmail() {

        // given
        List <Student> student = studentRepository.findAll();
        // when

        boolean result = studentRepository.selectExistsEmail(student.get(0).getEmail());

        // then
        assertThat(result).isTrue();
    }

    @Test
    void itShouldCheckIfStudentDoesNotExistEmail() {

        // given
        List <Student> student = studentRepository.findAll();
        // when

        boolean result = studentRepository.selectExistsEmail(student.get(0).getEmail() + "D");

        // then
        assertThat(result).isFalse();
    }
}