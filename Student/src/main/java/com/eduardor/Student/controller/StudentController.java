package com.eduardor.Student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.eduardor.Student.entity.Student;



@RestController
@RequestMapping("/student")

public class StudentController {


List<Student> sl ;

@PostConstruct
public void addstudents() {
sl = new ArrayList<>();
sl.add(new Student("Caleb",3.6,"jdtg0@aws.com","Female"));
sl.add(new Student("Aida",3.1,"adattt@test.gov","Female"));
sl.add(new Student("Alex",3.4,"Adavis@bccs.com","Male"));
sl.add(new Student("Meba",3.2,"mtravis@yahoo.com","Male"));

}

@RequestMapping("GetAll")
public List<Student> GetAllStudent(){
return sl;
}

@RequestMapping("GetByName")
public List<Student> GetByName(@RequestParam("name") String name){
List<Student> matchedStudents = new ArrayList<Student>();
for(Student currentStudent : sl) {
if(currentStudent.getName().equalsIgnoreCase(name)) {
matchedStudents.add(currentStudent);
}
}
return matchedStudents;
}


@RequestMapping("GetByGpaAndGender")
public List<Student> GetByGpaAndGender(@RequestParam("gpa") double gpa, @RequestParam("gender") String gender){
List<Student> matchedStudents = new ArrayList<Student>();
for(Student currentStudent : sl) {
if(currentStudent.getGpa()==gpa && currentStudent.getGender().equalsIgnoreCase(gender)) {
matchedStudents.add(currentStudent);
}
}
return matchedStudents;
}


@RequestMapping("GetAvgGpa")
public double GetAvgGpa() {
double totalGpa = 0;
int count = 0;
double avgGpa = 0;
for(Student currentStudent : sl) {
count++;
totalGpa += currentStudent.getGpa();
}
if(count>0) {
avgGpa = totalGpa/count;
}
return avgGpa;
}
}