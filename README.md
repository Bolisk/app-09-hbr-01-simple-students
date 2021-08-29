# Basic Hibernate Project

<br>
<br>

## 1. Goals

- Simple no built tool project
- Just Hibernate functionality
- Basic CRUD operations to DB
- mySQL queries
- queries cases and types
	- mySQL
	- JPQL
	- HQL

<br>

## 2. Create mySQL new User Script

```SQL
CREATE USER 'GUSLAB'@'localhost' IDENTIFIED BY 'ngin123';

GRANT ALL PRIVILEGES ON * . * TO 'GUSLAB'@'localhost';

-- we flash privileges
ALTER USER 'GUSLAB'@'localhost' 
IDENTIFIED WITH mysql_native_password 
BY 'ngin123';

-- optional
flush privileges;
```

<br>

## 3. Afterwards we create a basic table crm for the app


```SQL
-- the name indicates that it is a table 
-- for use with a framework and that is hb
-- hibernate
CREATE DATABASE  IF NOT EXISTS `fw_student_hb`;
USE `fw_student_hb`;

-- Table structure for table `student`

DROP TABLE IF EXISTS `student`;

CREATE TABLE student (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

```