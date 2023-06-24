create table milestones (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    milestone VARCHAR(256) NOT NULl,
    status VARCHAR(256) NOT NULl,
    priority integer NOT NULl,
    date date NOT NULL,
    category VARCHAR(256) NOT NULl
);

create table users (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL
);

