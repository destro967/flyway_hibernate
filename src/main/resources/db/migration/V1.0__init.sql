CREATE TABLE if not exists customer (
    id serial  primary key,
    firstname varchar(255) default null,
    lastname varchar(255) default null
);