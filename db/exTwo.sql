SELECT s.roll_number AS ROLL_NUMBER, s.name AS NAME, s.gender AS GENDER, s.dob AS DOB, s.email AS EMAIL, s.phone AS PHONE, s.address ADDRESS, c.name AS COLLEGE_NAME, d.dept_name AS DEPARTMENT_NAME
  FROM student AS s
       INNER JOIN college AS c
       ON c.id = s.college_id
       
       INNER JOIN college_department AS cd
       ON cd.cdept_id = s.cdept_id
       
       INNER JOIN department AS d
       ON d.dept_code = cd.udept_code
WHERE s.academic_year = 2014
  AND c.univ_code = 'PU'
  AND c.city = 'puducherry';