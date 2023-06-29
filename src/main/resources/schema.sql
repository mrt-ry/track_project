create table milestones (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    milestone VARCHAR(256) NOT NULl,
    status VARCHAR(256) NOT NULl,
    priority integer NOT NULl,
    date date NOT NULL,
    category VARCHAR(256) NOT NULl,
    project VARCHAR(256) NOT NULL
);

create table users (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    image VARCHAR(256) NOT NULL
);


create table projects (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    detail VARCHAR(256) NOT NULL,
    img VARCHAR(256) NOT NULL
);

