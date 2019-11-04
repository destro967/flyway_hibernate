CREATE TABLE if not exists customer (
    id serial  primary key,
    firstname varchar(255) default null,
    lastname varchar(255) default null
);

insert into customer(firstname, lastname) values ('Hello Koding','Simple coding examples and tutorials');
INSERT INTO customer(firstname, lastname) VALUES('Hello Koding 2', 'Simple coding examples and tutorials 2');