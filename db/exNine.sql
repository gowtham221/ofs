SELECT c.name AS COLLEGE_NAME, c.univ_code AS UNIVERSITY_CODE, s.roll_number AS ROLL_NUMBER, s.name AS STUDENT_NAME, s.academic_year AS ACADEMIC_YEAR, sf.paid_year AS PAID_YEAR, sf.paid_status AS PAID_STATUS
  FROM college AS c
       INNER JOIN student AS s
       ON s.college_id=c.id
       
       INNER JOIN semester_fee AS sf
       ON s.id=sf.stud_id
WHERE academic_year = '2014'
  AND c.univ_code='PU';
 
 
 
SELECT c.name AS COLLEGE_NAME, c.univ_code AS UNIVERSITY_CODE, s.roll_number AS ROLL_NUMBER, s.name AS STUDENT_NAME, s.academic_year AS ACADEMIC_YEAR, sf.paid_year AS PAID_YEAR, sf.paid_status AS PAID_STATUS
  FROM college AS c
       INNER JOIN student AS s
       ON s.college_id=c.id
       
       INNER JOIN semester_fee AS sf
       ON s.id=sf.stud_id
WHERE paid_status = 'PAID' 
  AND academic_year = '2014';
      
    