CREATE USER 'flashcard'@'localhost' IDENTIFIED BY 'flashcard';

GRANT ALL PRIVILEGES ON *.* TO 'flashcard'@'localhost';

ALTER USER 'flashcard'@'localhost' IDENTIFIED WITH mysql_native_password BY 'flashcard'