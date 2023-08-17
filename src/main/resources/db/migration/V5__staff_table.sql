
CREATE TABLE IF NOT EXISTS staff (
     id       SERIAL PRIMARY KEY,
     first_name VARCHAR(100) NOT NULL,
     last_name VARCHAR(100) NOT NULL,
     middle_name VARCHAR(100),
     date_of_birth VARCHAR(100) NOT NULL,
     gender VARCHAR(10) ,
     address VARCHAR(750),
     employment_status VARCHAR(105),
     job_role VARCHAR(105),
     year_of_employment INT,
     year_of_exit INT,
     health VARCHAR(200),
     FOREIGN KEY (health) REFERENCES health_record(email) ON DELETE CASCADE
) INHERITS (users);



CREATE TABLE IF NOT EXISTS staff_roles(

staff_id INTEGER REFERENCES staff(id) ,

role_id INTEGER REFERENCES role(role_id),
PRIMARY KEY(staff_id,role_id)

 );