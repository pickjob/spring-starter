-- student
INSERT INTO student VALUES ('40001010','Daniel','Radcliffe','1989-07-23');
INSERT INTO student VALUES ('40001011','Emma','Watson','1990-04-15');
INSERT INTO student VALUES ('40001012','Rupert','Grint','1988-10-24');
-- course
INSERT INTO course VALUES ('HUF07101','Herbology');
INSERT INTO course VALUES ('SLY07102','Defence Against the Dark Arts');
INSERT INTO course VALUES ('HUF08102','History of Magic');
-- student_course
INSERT INTO student_course VALUES ('40001010','SLY07102');
INSERT INTO student_course VALUES ('40001010','HUF07101');
INSERT INTO student_course VALUES ('40001010','HUF08102');
INSERT INTO student_course VALUES ('40001011','SLY07102');
INSERT INTO student_course VALUES ('40001011','HUF08102');
INSERT INTO student_course VALUES ('40001012','SLY07102');
INSERT INTO student_course VALUES ('40001012','HUF07101');

-- student
INSERT INTO student VALUES ('20001010','Hellen','Radcliffe','1989-07-23');
INSERT INTO student VALUES ('20001011','Amy','Watson','1990-04-15');
INSERT INTO student VALUES ('20001012','Json','Grint','1988-10-24');
-- course
INSERT INTO course VALUES ('M07101','Math');
INSERT INTO course VALUES ('A07102','Arts');
INSERT INTO course VALUES ('H08102','History');
-- student_course
INSERT INTO student_course VALUES ('20001010','M07101');
INSERT INTO student_course VALUES ('20001010','H08102');
INSERT INTO student_course VALUES ('20001010','A07102');
INSERT INTO student_course VALUES ('20001011','M07101');
INSERT INTO student_course VALUES ('20001011','A07102');
INSERT INTO student_course VALUES ('20001012','M07101');
INSERT INTO student_course VALUES ('20001012','H08102');