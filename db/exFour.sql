SELECT e.id AS EMPLOYEE_ID, e.name AS EMPLOYEE_NAME, e.dob AS DOB, e.email AS EMAIL, e.phone AS PHONE, e.college_id AS COLLEGE_ID, ds.name AS DESIGNATION_NAME, c.name AS COLLEGE_NAME, u.university_name AS UNIVERSITY_NAME, d.dept_name AS DEPARTMENT_NAME
  FROM university AS u
       INNER JOIN college AS c
       ON u.univ_code=c.univ_code
      
       INNER JOIN employee AS e
       ON c.id=e.college_id
      
       INNER JOIN designation AS ds
       ON e.desig_id=ds.id
      
       INNER JOIN college_department AS cd
       ON cd.cdept_id=e.cdept_id
      
       INNER JOIN department AS d
       ON d.dept_code=cd.udept_code
 WHERE (university_name LIKE "PON%")
 ORDER BY ds.rank, c.name;
     


