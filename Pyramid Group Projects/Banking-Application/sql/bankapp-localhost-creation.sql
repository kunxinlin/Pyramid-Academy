CREATE USER 'bankapp'@'localhost' IDENTIFIED BY 'bankapp';

GRANT ALL PRIVILEGES ON *.* TO 'bankapp'@'localhost';

ALTER USER 'bankapp'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password'