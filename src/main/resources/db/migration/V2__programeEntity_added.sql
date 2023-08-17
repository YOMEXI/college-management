
CREATE TABLE IF NOT EXISTS program
  (
     id                 SERIAL PRIMARY KEY,
     name               VARCHAR(200),
     department         INT,
     FOREIGN KEY (department) REFERENCES department(id)
     );




ALTER TABLE department ADD COLUMN programmes INTEGER;
ALTER TABLE department
ADD CONSTRAINT fk_program
FOREIGN KEY (programmes)
REFERENCES program(id);