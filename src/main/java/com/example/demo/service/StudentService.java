package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

//    public Student getStudentInfo(int studentId){
        public Student getStudentInfo(int studentId){
//        return studentRepository.findById(studentId);
        return studentRepository.findById(studentId).get();
    }

    public String removeStudent(int studentId){
//        Student removedStudent = studentRepository.removeById(studentId);
        studentRepository.deleteById(studentId);
        return "삭제완료";
//        String result = "";
//        if(removedStudent != null)
//            result = "정상적으로 삭제되었습니다.";
//        else
//            result = "삭제 과정에서 오류가 발생했습니다.";
//        return result;
    }

    public String addStudent(Student student){
//        String result = "";
//        Student addedStudent = studentRepository.add(student);
        studentRepository.save(student);
        return "등록 완료";
//        System.out.println(addedStudent);
//        if(addedStudent == null)
//            result = "정상적으로 추가되었습니다.";
//        else
//            result = "등록 과정에서 오류가 발생했습니다.";
//        return result;
    }

    public String updateStudent(int studentId, StudentDto studentDto){
        Student student = studentRepository.findById(studentId).get();
        student.setPoint(studentDto.getPoint());
        studentRepository.save(student);
        return "수정 완료";


//        Student foundStudent = studentRepository.findById(studentId);
//        foundStudent.setPoint(studentDto.getPoint());
//        studentRepository.update(studentId, foundStudent);
//        return "수정 완료";
    }
}

