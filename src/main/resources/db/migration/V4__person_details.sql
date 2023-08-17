

CREATE TABLE IF NOT EXISTS users (
     id       SERIAL PRIMARY KEY,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);





CREATE TYPE  ENROLLMENTSTATUS
AS ENUM ('ACTIVE', 'SUSPENDED',
'PROBATION', 'EXPELLED','GRADUATED');

CREATE TABLE IF NOT EXISTS health_record (
     id       SERIAL PRIMARY KEY,
     blood_group VARCHAR(15) NOT NULL,
     genotype VARCHAR(15) NOT NULL,
     health_issues VARCHAR(1500),
     email VARCHAR(100) UNIQUE NOT NULL

);





CREATE TABLE IF NOT EXISTS student (
     id       SERIAL PRIMARY KEY,
     matric_no VARCHAR(150) ,
     first_name VARCHAR(100) NOT NULL,
     last_name VARCHAR(100) NOT NULL,
     middle_name VARCHAR(100) NOT NULL,
     date_of_birth VARCHAR(100) NOT NULL ,
     gender VARCHAR(10) ,
     address VARCHAR(750),
     enrollment_status VARCHAR(105),
     year_of_registration INT,
     year_of_graduation INT,
     program INT,
     health VARCHAR(200),
     FOREIGN KEY (health) REFERENCES health_record(email) ON DELETE CASCADE,
     FOREIGN KEY (program) REFERENCES program(id)
) INHERITS (users);



CREATE TABLE IF NOT EXISTS student_roles(

student_id INTEGER REFERENCES student(id),

role_id INTEGER REFERENCES role(role_id),
PRIMARY KEY(student_id,role_id)

 );


