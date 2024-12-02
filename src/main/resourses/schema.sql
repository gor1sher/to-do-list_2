CREATE TABLE IF NOT EXISTS tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(255),
    localDateBegin DATE,
    localDateEnd DATE,
    status VARCHAR
);
