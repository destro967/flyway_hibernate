CREATE TABLE if not exists book (
    id serial  primary key,
    description varchar(255) default null,
    title varchar(255) default null
);