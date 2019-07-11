create database hackmedb
use hackmedb
CREATE TABLE books (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), author VARCHAR(255))
INSERT INTO books (name, authoer) VALUES ('Sapiens', 'Yuval Noah Harari')

CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), password VARCHAR(255), role VARCHAR(255))
INSERT INTO users (username, password, role) VALUES ('john', 'john123', 'ADMIN')
	

