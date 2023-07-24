CREATE TABLE IF NOT EXISTS faculty
  (
     id                 SERIAL NOT NULL,
     faculty_name       VARCHAR(100),
     faculty_code       VARCHAR(100),
     PRIMARY KEY (id)
     );

CREATE TABLE IF NOT EXISTS department
  (
      id                   SERIAL NOT NULL,
     department_name       VARCHAR(100),
     department_code       VARCHAR(100),
     PRIMARY KEY (id)

      );

ALTER TABLE department ADD COLUMN faculty INTEGER;
ALTER table department
ADD CONSTRAINT fk_department
FOREIGN KEY (faculty)
REFERENCES faculty (id);

