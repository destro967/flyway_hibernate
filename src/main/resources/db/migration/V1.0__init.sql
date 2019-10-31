CREATE TABLE if not exists book (
    id serial  primary key,
    description varchar(255) default null,
    tite varchar(255) default null
);