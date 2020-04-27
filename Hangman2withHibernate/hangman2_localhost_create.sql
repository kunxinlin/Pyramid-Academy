CREATE USER 'hbHangman'@'localhost' IDENTIFIED BY 'hbHangman';

GRANT ALL PRIVILEGES ON * . * TO 'hbHangman'@'localhost';

ALTER USER 'hbHangman'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';