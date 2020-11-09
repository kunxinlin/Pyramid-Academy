CREATE USER 'partsDirectory'@'localhost' IDENTIFIED BY 'partsDirectory';

GRANT ALL PRIVILEGES ON * . * TO 'partsDirectory'@'localhost';

ALTER USER 'partsDirectory'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';