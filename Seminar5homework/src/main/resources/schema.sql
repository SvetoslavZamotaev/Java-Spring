create table if not exists tasks
(
    id          int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description TEXT            not null,
    status      varchar(32),
    datetime TIMESTAMP
);
