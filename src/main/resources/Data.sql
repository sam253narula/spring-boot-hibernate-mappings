insert into passport (id, number) values(1,'IND100');
insert into passport (id, number) values(2,'IND101');

insert into student (id,name,passport_id) values (1,'Sam',1);
insert into student (id,name,passport_id) values (2,'Hiren',2);

insert into course(id, name, created_date, last_updated_date) 
values(1,'Learning Spring with Spring Boot', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(2,'Learn Creational Design Patterns in java', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(3,'Microservices with Spring Boot', sysdate(), sysdate());

insert into review(id,rating,description,course_id)
values(1,'FIVE', 'Great Course',1);
insert into review(id,rating,description,course_id)
values(2,'FOUR', 'Wonderful Course',1);
insert into review(id,rating,description,course_id)
values(3,'FIVE', 'Awesome Course',2);

insert into student_course(student_id,course_id)
values(1,1);
insert into student_course(student_id,course_id)
values(1,2);
insert into student_course(student_id,course_id)
values(2,2);
insert into student_course(student_id,course_id)
values(2,3);