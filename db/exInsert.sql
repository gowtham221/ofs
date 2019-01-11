INSERT INTO university (univ_code, university_name)
VALUES ('AU', 'ANNA UNIVERSITY'),
	   ('AMU', 'ANNAMALAI UNIVERSITY'),
	   ('PU', 'PONDICHERRY UNIVERSITY'),
	   ('MADU', 'MADRAS UNIVERSITY');
		 
		 
INSERT INTO designation (id, name, rank)
VALUES ('1', 'PRINCIPAL', 'A'),
	   ('2', 'HOD', 'B'),
	   ('3', 'PROFESSOR', 'C'),
	   ('4', 'LAB ASSISTANT', 'D');
		 
INSERT INTO department (dept_code, dept_name, univ_code)
VALUES ('EEA', 'Electrical Engineering', 'AU'),
       ('EEAM', 'Electrical Engineering', 'AMU'),
       ('EEP', 'Electrical Engineering', 'PU'),
       ('EEM', 'Electrical Engineering', 'MADU'),
	   ('ECA', 'Electronics and Communication Engineering', 'AU'),
       ('ECAM', 'Electronics and Communication Engineering', 'AMU'),
       ('ECP', 'Electronics and Communication Engineering', 'PU'),
       ('ECM', 'Electronics and Communication Engineering', 'MADU'),
       ('ITA', 'Information Technology', 'AU'),
       ('ITAM', 'Information Technology', 'AMU'),
       ('ITP', 'Information Technology', 'PU'),
	   ('ITM', 'Information Technology', 'MADU'),
	   ('CSE', 'Computer Science Engineering', 'MADU'),
       ('MECH', 'Mechanical Engineering', 'PU');
		 
INSERT INTO college (id, code, name, univ_code, city, state, year_opened)
VALUES (101, 'SMV', 'Sri Manakula Vinayagar Engineering College', 'PU', 'Puducherry', 'Puducherry', 1991),
       (102, 'PEC', 'Pondicherry Engineering College', 'PU', 'Puducherry', 'Puducherry', 1970),
       (103, 'MIT', 'Madras Institute of Technology', 'MADU', 'Chennai', 'Tamil Nadu', 1907),
       (104, 'AGNI', 'Agni Engineering College', 'AU', 'Chennai', 'Tamil Nadu', 1992),
       (105, 'ACE', 'Annamalai College of Engineering', 'AMU', 'Chidambaram', 'Tamil Nadu', 1986);
       
INSERT INTO college_department (cdept_id, udept_code, college_id)
VALUES (201, 'ITP', 101),
       (202, 'MECH', 101),
       (203, 'ECP', 101),
       (204, 'EEP', 101),
       (205, 'ITP', 102),
       (206, 'MECH', 102),
       (207, 'ECP', 102),
       (208, 'EEP', 102),
       (209, 'EEM', 103),
       (210, 'ECM', 103),
       (211, 'ITM', 103),
       (212, 'CSE', 103),
       (213, 'EEA', 104),
       (214, 'ECAM', 105),
       (215, 'ITA', 104),
       (216, 'ITAM', 105);

               

INSERT INTO employee (id, name, dob, email, phone, college_id, cdept_id, desig_id)
VALUES (301, 'ramesh', '1985-09-15', 'ramesh@gamil.com', 9876543201, 101, 201, 1),
       (302, 'suresh', '1989-07-05', 'suresh@gamil.com', 9875643201, 101, 201, 2),
       (304, 'magesh', '1976-01-10', 'magesh@gamil.com', 9873643501, 101, 201, 3),
       (313, 'prabu', '1989-11-05', 'prabu@gamil.com', 6975643201, 101, 201, 4),
       (314, 'chandru', '1976-12-10', 'chandru@gamil.com', 5973643501, 101, 202, 2),
       (315, 'naren', '1977-03-16', 'naren@gamil.com', 9473693501, 101, 202, 3),
       (316, 'mani', '1983-01-10', 'mani@gamil.com', 7873653201, 101, 202, 4),
       (317, 'varun', '1989-05-10', 'varun@gamil.com', 8773943201, 101, 203, 2),
       (306, 'rajesh', '1989-01-10', 'rajesh@gamil.com', 9773643201, 101, 203, 1),
       (303, 'vignesh', '1986-01-10', 'vigesh@gamil.com', 9873643201, 101, 204, 3),
       (305, 'manik', '1977-03-17', 'manik@gamil.com', 9873693501, 101, 204, 2), 
       (312, 'dipak', '1975-09-15', 'dipak@gamil.com', 9876563201, 101, 204, 1),
       (307, 'vel', '1989-11-05', 'vel@gamil.com', 6875643201, 102, 205, 3),
       (308, 'sakthi', '1976-12-10', 'sakthi@gamil.com', 5873643501, 102, 205, 4),
       (309, 'surya', '1977-03-16', 'surya@gamil.com', 9373693501, 102, 205, 2),
       (310, 'bonam', '1983-01-10', 'bonam@gamil.com', 7873643201, 102, 206, 3),
       (311, 'pratap', '1989-05-10', 'pratap@gamil.com', 8773643201, 102, 206, 1),
       (318, 'aramesh', '1985-09-15', 'ramesh@gamil.com', 9876543201, 102, 207, 2),
       (319, 'asuresh', '1989-07-05', 'suresh@gamil.com', 9875643201, 102, 207, 3),
       (320, 'amagesh', '1976-01-10', 'magesh@gamil.com', 9873643501, 102, 208, 2),
       (321, 'aprabu', '1989-11-05', 'prabu@gamil.com', 6975643201, 103, 209, 3),
       (322, 'achandru', '1976-12-10', 'chandru@gamil.com', 5973643501, 103, 209, 1);
       
       
INSERT INTO student (id, roll_number, name, dob, gender, email, phone, address, academic_year, cdept_id, college_id)
VALUES  (401, '1', 'Palmer', '1994-05-14', 'M', 'Palmer@gmail.com', 8876544413, 'pondicherry', '2014', 201, 101),
        (402, '2', 'Paris', '1995-12-01', 'M', 'paris@gmail.com', 9876585414, 'pondicherry', '2015', 202, 101),
        (403, '3', 'Parker', '1996-08-31', 'M', 'parker@gmail.com', 9876524415, 'pondicherry', '2016', 203, 101),
        (404, '4', 'Pasqua', '1993-09-26', 'M', 'Pasqua@gmail.com', 9876544416, 'pondicherry', '2018', 204, 101),
        (405, '5', 'Pat', '1994-01-20', 'M', 'Pat@gmail.com', 9876544417, 'pondicherry', '2014', 205, 102),
        (406, '6', 'Patric', '1995-02-16', 'M', 'Patric@gmail.com', 9876544418, 'pondicherry', '2015', 206, 102),
        (407, '7', 'Patrick', '1996-10-12', 'M', 'Patrick@gmail.com', 9876544419, 'pondicherry', '2016', 207, 102),
        (408, '8', 'Paul', '1993-12-31', 'M', 'Paul@gmail.com', 9876544420, 'pondicherry', '2018', 208, 102),
        (409, '9', 'Pedro', '1994-02-12', 'M', 'Pedro@gmail.com', 9876544421, 'chennai', '2014', 209, 103),
        (410, '10', 'Percy', '1995-12-31', 'M', 'Percy@gmail.com', 9876544422, 'chennai', '2015', 210, 103),
        (411, '11', 'Perry', '1996-10-04', 'M', 'Perry@gmail.com', 9876544423, 'chennai', '2016', 211, 103),
        (412, '12', 'Pete', '1993-12-12', 'M', 'Pete@gmail.com', 9876544424, 'chennai', '2018', 212, 103),
        (413, '13', 'Peter', '1994-05-18', 'M', 'Peter@gmail.com', 9876541425, 'chennai', '2014', 213, 104),
        (414, '14', 'aPalmer', '1994-05-14', 'M', 'aPalmer@gmail.com', 9852544413, 'chennai', '2014', 215, 105),
        (415, '15', 'aParis', '1995-12-01', 'M', 'aparis@gmail.com', 9876364414, 'chennai', '2015', 216, 105),
        (416, '16', 'aParker', '1996-08-31', 'M', 'aparker@gmail.com', 9876454415, 'chennai', '2016', 215, 105),
        (417, '17', 'aPasqua', '1993-09-26', 'M', 'aPasqua@gmail.com', 9876541256, 'chennai', '2018', 216, 105),
        (418, '18', 'aPat', '1994-01-20', 'M', 'aPat@gmail.com', 9876544445, 'pondicherry', '2014', 215, 105),
        (419, '19', 'aPatric', '1995-02-16', 'M', 'aPatric@gmail.com', 9876632418, 'pondicherry', '2015', 216, 104),
        (420, '20', 'aPatrick', '1996-10-12', 'M', 'aPatrick@gmail.com', 9876545619, 'pondicherry', '2016', 216, 105),
        (421, '21', 'zPalmer', '1994-05-14', 'M', 'Palmer@gmail.com', 8876544413, 'pondicherry', '2014', 201, 101),
        (422, '22', 'zParis', '1995-12-01', 'M', 'paris@gmail.com', 9876585414, 'pondicherry', '2015', 202, 101),
        (423, '23', 'zParker', '1996-08-31', 'M', 'parker@gmail.com', 9876524415, 'pondicherry', '2016', 203, 101),
        (424, '24', 'zPasqua', '1993-09-26', 'M', 'Pasqua@gmail.com', 9876544416, 'pondicherry', '2018', 204, 101),
        (425, '25', 'zPat', '1994-01-20', 'M', 'Pat@gmail.com', 9876544417, 'pondicherry', '2014', 205, 102),
        (426, '26', 'zPatric', '1995-02-16', 'M', 'Patric@gmail.com', 9876544418, 'pondicherry', '2015', 206, 102),
        (427, '27', 'zPatrick', '1996-10-12', 'M', 'Patrick@gmail.com', 9876544419, 'pondicherry', '2016', 207, 102),
        (428, '28', 'zPaul', '1993-12-31', 'M', 'Paul@gmail.com', 9876544420, 'pondicherry', '2018', 208, 102),
        (429, '29', 'zPedro', '1994-02-12', 'M', 'Pedro@gmail.com', 9876544421, 'chennai', '2014', 209, 103),
        (430, '30', 'zPercy', '1995-12-31', 'M', 'Percy@gmail.com', 9876544422, 'chennai', '2015', 210, 103),
        (431, '31', 'zPerry', '1996-10-04', 'M', 'Perry@gmail.com', 9876544423, 'chennai', '2016', 211, 103),
        (432, '32', 'zPete', '1993-12-12', 'M', 'Pete@gmail.com', 9876544424, 'chennai', '2018', 212, 103),
        (433, '33', 'zPeter', '1994-05-18', 'M', 'Peter@gmail.com', 9876541425, 'chennai', '2014', 213, 104),
        (434, '34', 'zaPalmer', '1994-05-14', 'M', 'aPalmer@gmail.com', 9852544413, 'chennai', '2014', 215, 105),
        (435, '35', 'zaParis', '1995-12-01', 'M', 'aparis@gmail.com', 9876364414, 'chennai', '2015', 216, 105),
        (436, '36', 'zaParker', '1996-08-31', 'M', 'aparker@gmail.com', 9876454415, 'chennai', '2016', 215, 105),
        (437, '37', 'zaPasqua', '1993-09-26', 'M', 'aPasqua@gmail.com', 9876541256, 'chennai', '2018', 216, 105),
        (438, '38', 'zaPat', '1994-01-20', 'M', 'aPat@gmail.com', 9876544445, 'pondicherry', '2014', 215, 105),
        (439, '39', 'zaPatric', '1995-02-16', 'M', 'aPatric@gmail.com', 9876632418, 'pondicherry', '2015', 216, 104),
        (440, '40', 'zaPatrick', '1996-10-12', 'M', 'aPatrick@gmail.com', 9876545619, 'pondicherry', '2016', 216, 105),
        (441, '41', 'yPalmer', '1994-05-14', 'M', 'Palmer@gmail.com', 8876544413, 'pondicherry', '2014', 201, 101),
        (442, '42', 'yParis', '1995-12-01', 'M', 'paris@gmail.com', 9876585414, 'pondicherry', '2015', 202, 101),
        (443, '43', 'yParker', '1996-08-31', 'M', 'parker@gmail.com', 9876524415, 'pondicherry', '2016', 203, 101),
        (444, '44', 'yPasqua', '1993-09-26', 'M', 'Pasqua@gmail.com', 9876544416, 'pondicherry', '2018', 204, 101),
        (445, '45', 'yPat', '1994-01-20', 'M', 'Pat@gmail.com', 9876544417, 'pondicherry', '2014', 205, 102),
        (446, '46', 'yPatric', '1995-02-16', 'M', 'Patric@gmail.com', 9876544418, 'pondicherry', '2015', 206, 102),
        (447, '47', 'yPatrick', '1996-10-12', 'M', 'Patrick@gmail.com', 9876544419, 'pondicherry', '2016', 207, 102),
        (448, '48', 'yPaul', '1993-12-31', 'M', 'Paul@gmail.com', 9876544420, 'pondicherry', '2018', 208, 102);
        

INSERT INTO syllabus (id, cdept_id, syllabus_code, syllabus_name)
VALUES (1, 201, 'ITP', 'oops'),
       (2, 202, 'MECH', 'thermodynamics'),
       (3, 203, 'ECP', 'mpmc'),
       (4, 204, 'EEP', 'motors'),
       (5, 205, 'ITP', 'oops'),
       (6, 206, 'MECH', 'thermodynamics'),
       (7, 207, 'ECP', 'mpmc'),
       (8, 208, 'EEP', 'motors'),
       (9, 209, 'EEM', 'motors'),
       (10, 210, 'ECM', 'mpmc'),
       (11, 211, 'ITM', 'oops'),
       (12, 212, 'CSE', 'cp'),
       (13, 213, 'EEA', 'motors'),
       (14, 214, 'ECAM', 'mpmc'),
       (15, 215, 'ITA', 'oops'),
       (16, 216, 'ITAM', 'oops');
                   
                   
   
		
INSERT INTO professor_syllabus (emp_id, syllabus_id, semester)
VALUES (301, 1, 6),
	   (302, 2, 6),
	   (304, 3, 4),
	   (313, 4, 2),
	   (314, 5, 7),
	   (315, 6, 5),
	   (316, 7, 8),
	   (317, 8, 7),
	   (306, 9, 5),
	   (303, 10, 5),
	   (305, 11, 4),
	   (312, 12, 4),
	   (307, 13, 3),
	   (308, 14, 1),
	   (309, 15, 1),
	   (310, 16, 2),
	   (311, 1, 5),
	   (318, 2, 7),
	   (319, 3, 3),
	   (320, 4, 2),
	   (321, 5, 2),
	   (322, 6, 1);
       
       
INSERT INTO semester_fee (cdept_id, stud_id, semester)
VALUES (201, 401, 1), 
       (202, 402, 1), 
       (203, 403, 1), 
       (204, 404, 1), 
       (205, 405, 1), 
       (206, 406, 1), 
       (207, 407, 1), 
       (208, 408, 1), 
       (209, 409, 1), 
       (210, 410, 1),
       (211, 411, 3),
       (212, 412, 3),
       (213, 413, 3),
       (215, 414, 3),
       (216, 415, 3),
       (215, 416, 3),
       (216, 417, 3),
       (215, 418, 3),
       (216, 419, 3),
       (216, 420, 3),
       (201, 421, 5),
       (202, 422, 5),
       (203, 423, 5),
       (204, 424, 5),
       (205, 425, 5),
       (206, 426, 5),
       (207, 427, 5),
       (208, 428, 5),
       (209, 429, 5),
       (210, 430, 5),
       (211, 431, 7),
       (212, 432, 7),
       (213, 433, 7),
       (215, 434, 7),
       (216, 435, 7),
       (215, 436, 7),
       (216, 437, 7),
       (215, 438, 7),
       (216, 439, 7),
       (216, 440, 7),
       (201, 441, 1),
       (202, 442, 3),
       (203, 443, 5),
       (204, 444, 7),
       (205, 445, 1),
       (206, 446, 3),
       (207, 447, 5),
       (208, 448, 7);

       
INSERT INTO semester_result (stud_id, syllabus_id, semester, grade, credits, result_date)
VALUES (401, 1, 1, 'S', 4, '2018-08-27'),
       (402, 2, 1, 'A', 4, '2018-08-27'),
       (403, 3, 1, 'B', 4, '2018-08-27'),
       (404, 4, 1, 'C', 4, '2018-08-27'),
       (405, 5, 1, 'D', 4, '2018-08-27'),
       (406, 6, 1, 'E', 4, '2018-08-27'),
       (407, 7, 1, 'S', 4, '2018-08-27'),
       (408, 8, 1, 'A', 4, '2018-08-27'),
       (409, 9, 1, 'B', 4, '2018-08-27'),
       (410, 10, 1, 'C', 4, '2018-08-27'),
       (411, 11, 3, 'D', 4, '2018-08-27'),
       (412, 12, 3, 'E', 4, '2018-08-27'),
       (413, 13, 3, 'C', 4, '2018-08-27'),
       (414, 15, 3, 'D', 4, '2018-08-27'),
       (415, 16, 3, 'E', 4, '2018-08-27'),
       (416, 15, 3, 'S', 4, '2018-08-27'),
       (417, 16, 3, 'S', 4, '2018-08-27'),
       (418, 15, 3, 'A', 4, '2018-08-27'),
       (419, 16, 3, 'B', 4, '2018-08-27'),
       (420, 16, 3, 'C', 4, '2018-08-27'),
       (421, 1, 5, 'D', 4, '2018-08-27'),
       (422, 2, 5, 'E', 4, '2018-08-27'),
       (423, 3, 5, 'S', 4, '2018-08-27'),
       (424, 4, 5, 'A', 4, '2018-08-27'),
       (425, 5, 5, 'B', 4, '2018-08-27'),
       (426, 6, 5, 'C', 4, '2018-08-27'),
       (427, 7, 5, 'D', 4, '2018-08-27'),
       (428, 8, 5, 'E', 4, '2018-08-27'),
       (429, 9, 5, 'S', 4, '2018-08-27'),
       (430, 10, 5, 'A', 4, '2018-08-27'),
       (431, 11, 7, 'B', 4, '2018-08-27'),
       (432, 12, 7, 'C', 4, '2018-08-27'),
       (433, 13, 7, 'D', 4, '2018-08-27'),
       (434, 15, 7, 'E', 4, '2018-08-27'),
       (435, 16, 7, 'S', 4, '2018-08-27'),
       (436, 15, 7, 'A', 4, '2018-08-27'),
       (437, 16, 7, 'B', 4, '2018-08-27'),
       (438, 15, 7, 'C', 4, '2018-08-27'),
       (439, 16, 7, 'D', 4, '2018-08-27'),
       (440, 16, 7, 'E', 4, '2018-08-27'),
       (441, 1, 1, 'S', 4, '2018-08-27'),
       (442, 2, 3, 'A', 4, '2018-08-27'),
       (443, 3, 5, 'B', 4, '2018-08-27'),
       (444, 4, 7, 'C', 4, '2018-08-27'),
       (445, 5, 1, 'D', 4, '2018-08-27'),
       (446, 6, 3, 'E', 4, '2018-08-27'),
       (447, 7, 5, 'C', 4, '2018-08-27'),
       (448, 8, 7, 'D', 4, '2018-08-27');
       