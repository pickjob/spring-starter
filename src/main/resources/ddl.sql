DROP DATABASE IF EXISTS school;
CREATE DATABASE school DEFAULT CHARACTER SET = utf8mb4;

USE school;

CREATE TABLE IF NOT EXISTS student(
  matric_no CHAR(8) PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  date_of_birth DATE
);
CREATE TABLE IF NOT EXISTS course(
  course_code CHAR(8) PRIMARY KEY,
  course_title VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS student_course(
  matric_no CHAR(8),
  course_code CHAR(8),
  FOREIGN KEY (matric_no) REFERENCES student(matric_no),
  FOREIGN KEY (course_code) REFERENCES course(course_code)
);