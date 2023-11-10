DROP TABLE IF EXISTS person, instructor, program, qualification, location, class, register;

CREATE TABLE person
(
    _id        INT         NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    PRIMARY KEY (_id)
);

CREATE TABLE instructor
(
    _id            INT           NOT NULL AUTO_INCREMENT,
    person_id      INT           NOT NULL,
    bio            VARCHAR(1000) NOT NULL,
    business_phone VARCHAR(20)   NOT NULL,
    PRIMARY KEY (_id),
    FOREIGN KEY (person_id)
        REFERENCES person (_id)
);

CREATE TABLE program
(
    _id         INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (_id)
);

CREATE TABLE qualification
(
    _id           INT NOT NULL AUTO_INCREMENT,
    instructor_id INT NOT NULL,
    program_id    INT NOT NULL,
    PRIMARY KEY (_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (_id),
    FOREIGN KEY (program_id)
        REFERENCES program (_id),
    UNIQUE KEY unique_key (instructor_id, program_id)
);

CREATE TABLE location
(
    _id         INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(200) NOT NULL,
    area        INT          NOT NULL,
    PRIMARY KEY (_id)
);

CREATE TABLE class
(
    _id             INT      NOT NULL AUTO_INCREMENT,
    start_time      DATETIME NOT NULL,
    end_time        DATETIME NOT NULL,
    available_space INT,
    instructor_id   INT      NOT NULL,
    program_id      INT      NOT NULL,
    location_id     INT      NOT NULL,
    PRIMARY KEY (_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (_id),
    FOREIGN KEY (program_id)
        REFERENCES program (_id),
    FOREIGN KEY (location_id)
        REFERENCES location (_id)
);

CREATE TABLE register
(
    _id       INT NOT NULL AUTO_INCREMENT,
    person_id INT NOT NULL,
    class_id  INT NOT NULL,
    PRIMARY KEY (_id),
    FOREIGN KEY (person_id)
        REFERENCES person (_id),
    FOREIGN KEY (class_id)
        REFERENCES class (_id),
    UNIQUE KEY unique_key (person_id, class_id)
);


insert into person (first_name, last_name, email)
values ('a', 'b', 'c'),
       ('f', 'g', 'h');
insert into instructor (person_id, bio, business_phone)
values (2, 'a', 'b');
insert into program (name, description)
values ('yoga', 'yoga_desc');
insert into qualification (instructor_id, program_id)
values (1, 1);
insert into location (name, description, area)
values ('room 1', 'room 1', 100);
insert into class (start_time, end_time, available_space, instructor_id, program_id, location_id)
values ('2023-11-01 10:00:00', '2023-11-01 10:45:00', 18, 1, 1, 1);
insert into register (person_id, class_id)
values (2, 1);