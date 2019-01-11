SELECT c.code AS CODE, c.name AS COLLEGE_NAME, u.university_name AS UNIVERSITY_NAME ,c.city AS CITY, c.state AS STATE, c.year_opened AS YEAR_OPENED, d.dept_name AS DEPARTMEMNT_NAME, e.name AS HOD_NAME
  FROM university AS u
       INNER JOIN college AS c
       ON u.univ_code=c.univ_code
      
       INNER JOIN employee AS e
       ON c.id=e.college_id
      
       CROSS JOIN college_department AS cd
       ON cd.cdept_id=e.cdept_id
      
       INNER JOIN department AS d 
       ON d.dept_code=cd.udept_code
      
       INNER JOIN designation AS ds
       ON ds.id=e.desig_id
 WHERE ds.name =('HOD')
   AND d.dept_name IN ('Information technology','Computer Science Engineering');