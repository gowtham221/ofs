SELECT s.id AS STUDENT_ID, s.roll_number AS ROLL_NUMBER, s.name AS STUDENT_NAME, s.dob AS DOB, s.gender AS GENDER, s.email AS EMAIL, s.phone AS PHONE_NUMBER, s.academic_year AS ACADEMIC_YEAR, c.name AS COLLEGE_NAME, sr.semester AS SEMESTER, ((sr.grade * sr.credits) / (sr.credits)) AS GPA
  FROM student AS s
       INNER JOIN semester_result AS sr
       ON s.id=sr.stud_id
      
       INNER JOIN college AS c
       ON s.college_id=c.id
 ORDER BY c.name, sr.semester LIMIT 0,15;
          
      
      
