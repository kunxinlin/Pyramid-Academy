CREATE USER 'studentcatalog'@'localhost' IDENTIFIED BY 'studentcatalog';

GRANT ALL PRIVILEGES ON *.* TO 'studentcatalog'@'localhost';

ALTER USER 'studentcatalog'@'localhost' IDENTIFIED WITH mysql_native_password BY 'studentcatalog'