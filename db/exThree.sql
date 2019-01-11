SELECT s.roll_number AS ROLL_NUMBER, s.name NAME, s.gender AS GENDER, s.dob AS DOB, s.email AS EMAIL, s.phone AS PHONE, s.address AS ADDRESS, c.name COLLEGE_NAME, d.dept_name AS DEPARTMENT_NAME, e.name AS HOD_NAME
  FROM student AS s
       INNER JOIN college AS c
       ON c.id = s.college_id
       
       INNER JOIN college_department AS cd
       ON cd.cdept_id = s.cdept_id
       
       INNER JOIN department AS d
       ON d.dept_code = cd.udept_code
       
       INNER JOIN employee AS e
       ON e.cdept_id = cd.cdept_id
WHERE c.univ_code = 'PU'
  AND c.city = 'puducherry'
  AND e.desig_id = 2 LIMIT 0,20;