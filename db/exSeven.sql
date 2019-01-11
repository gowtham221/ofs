SELECT s.roll_number AS ROLL_NUMBER, sf.semester AS SEMESTER,sf.paid_year AS PAID_YEAR, sf.paid_status AS PAID_STATUS
  FROM semester_fee AS sf
       INNER JOIN student AS s
       ON s.id = sf.stud_id;

UPDATE semester_fee AS sf
   SET sf.paid_status = 'Paid', 
       sf.paid_year = 2018
 WHERE sf.stud_id = (SELECT id 
                       FROM student AS s
                      WHERE s.roll_number = 15s);
 
UPDATE semester_fee AS sf
   SET sf.paid_status = 'Paid', 
       sf.paid_year = 2018
 WHERE sf.stud_id IN (SELECT id 
                       FROM student AS s
                      WHERE s.roll_number IN (2,3,4,5,6,7,8,9,10));
                      
                      