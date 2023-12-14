DROP TABLE IF EXISTS person, instructor, program, qualification, location, class, booking;

CREATE TABLE person
(
    person_id  INT         NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    email      VARCHAR(50) NOT NULL UNIQUE,
    username   VARCHAR(30) NOT NULL UNIQUE,
    password   VARCHAR(30) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE instructor
(
    instructor_id  INT           NOT NULL,
    bio            VARCHAR(1000) NOT NULL,
    business_phone VARCHAR(20)   NOT NULL,
    PRIMARY KEY (instructor_id),
    FOREIGN KEY (instructor_id)
        REFERENCES person (person_id)
);

CREATE TABLE program
(
    program_id  INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (program_id)
);

CREATE TABLE qualification
(
    instructor_id INT NOT NULL,
    program_id    INT NOT NULL,
    PRIMARY KEY (instructor_id, program_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (instructor_id),
    FOREIGN KEY (program_id)
        REFERENCES program (program_id),
    UNIQUE KEY unique_key (instructor_id, program_id)
);

CREATE TABLE location
(
    location_id INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    description VARCHAR(200) NOT NULL,
    room_size   INT          NOT NULL,
    PRIMARY KEY (location_id)
);

CREATE TABLE class
(
    class_id       INT      NOT NULL AUTO_INCREMENT,
    start_time     DATETIME NOT NULL,
    end_time       DATETIME NOT NULL,
    total_capacity INT,
    instructor_id  INT      NOT NULL,
    program_id     INT      NOT NULL,
    location_id    INT      NOT NULL,
    PRIMARY KEY (class_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (instructor_id),
    FOREIGN KEY (program_id)
        REFERENCES program (program_id),
    FOREIGN KEY (location_id)
        REFERENCES location (location_id)
);

CREATE TABLE booking
(
    person_id INT NOT NULL,
    class_id  INT NOT NULL,
    PRIMARY KEY (person_id, class_id),
    FOREIGN KEY (person_id)
        REFERENCES person (person_id),
    FOREIGN KEY (class_id)
        REFERENCES class (class_id),
    UNIQUE KEY unique_key (person_id, class_id)
);


insert into person (first_name, last_name, email, username, password)
values ('First name 1', 'Last name 1', 'email1@gmail.com', 'user1', 'pass'),
       ('First name 2', 'Last name 2', 'email2@gmail.com', 'user2', 'pass'),
       ('First name 3', 'Last name 3', 'email3@gmail.com', 'user3', 'pass'),
       ('First name 4', 'Last name 4', 'email4@gmail.com', 'user4', 'pass'),
       ('First name 5', 'Last name 5', 'email5@gmail.com', 'user5', 'pass'),
       ('First name 6', 'Last name 6', 'email6@gmail.com', 'user6', 'pass'),
       ('First name 7', 'Last name 7', 'email7@gmail.com', 'user7', 'pass'),
       ('First name 8', 'Last name 8', 'email8@gmail.com', 'user8', 'pass'),
       ('First name 9', 'Last name 9', 'email9@gmail.com', 'user9', 'pass'),
       ('First name 10', 'Last name 10', 'email10@gmail.com', 'user10', 'pass'),
       ('First name 11', 'Last name 11', 'email11@gmail.com', 'user11', 'pass'),
       ('First name 12', 'Last name 12', 'email12@gmail.com', 'user12', 'pass'),
       ('First name 13', 'Last name 13', 'email13@gmail.com', 'user13', 'pass'),
       ('First name 14', 'Last name 14', 'email14@gmail.com', 'user14', 'pass'),
       ('First name 15', 'Last name 15', 'email15@gmail.com', 'user15', 'pass'),
       ('First name 16', 'Last name 16', 'email16@gmail.com', 'user16', 'pass'),
       ('First name 17', 'Last name 17', 'email17@gmail.com', 'user17', 'pass'),
       ('First name 18', 'Last name 18', 'email18@gmail.com', 'user18', 'pass'),
       ('First name 19', 'Last name 19', 'email19@gmail.com', 'user19', 'pass');
insert into instructor (instructor_id, bio, business_phone)
values (1, 'Bio 1', '902-123-4567'),
       (2, 'Bio 2', '902-123-5678'),
       (3, 'Bio 3', '902-123-6789'),
       (4, 'Bio 4', '902-345-4567'),
       (5, 'Bio 5', '902-678-4567');
insert into program (name, description)
values ('Core Strength',
        'This class focuses on core conditioning, stabilization, and strength through a variety of exercises. Be prepared to work on proper movement, challenge your core and feel the burn through core targeting compound movements and mat exercises.'),
       ('Meditation',
        'Calm your mind and body and address your stressors both positive and negative with this relaxing Yoga Nidra style meditation. This meditation practice will increase delta brainwaves and access your inner calm, and creativity more freely.'),
       ('Spin',
        'Get on your bikes and ride! This class uses Keiser spin bikes to give you the best low impact cardio workout around. Burn calories and have a blast doing it throughout this interval style spin workout. Enjoy hills and valley\'s all from the comfort of our studio.'),
       ('Synergy Circuit',
        'Join us for a challenging, fun, and inviting new workout on our "adult playground", the Synergy 360! This circuit training workout combines both strength and conditioning stations using a variety of equipment both on and around the Synergy to develop muscular strength and endurance, with an emphasis on functional movement and proper execution. Burn calories while toning arms, legs, abs and glutes with this team training style workout!'),
       ('Tai Chi',
        'The "Tai Chi for Health – Set of 24" is a simplified and widely practiced routine within the realm of Tai Chi, designed to provide numerous health benefits through a sequence of 24 movements. This set is often used as an introductory or beginner-friendly form due to its shorter length and focus on fundamental Tai Chi principles. It can be practiced by individuals of various ages and fitness levels, promoting relaxation, balance, flexibility, and overall well-being.'),
       ('Yoga',
        'Introductory Yoga good for those who want flexibility and relaxation. Elongate, strengthen, and stretch your way to better health with this breath focused flow.'),
       ('Zumba',
        'Fun, effective, easy to follow, Latin-inspired, calorie burning dance fitness party! Follow along to the beat of the music and learn a few new dance moves while simultaneously getting a cardio workout. You will be having so much fun you won''t even realize how hard you worked :)');
insert into qualification (instructor_id, program_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 7),
       (2, 2),
       (2, 3),
       (3, 3),
       (3, 4),
       (3, 5),
       (4, 5),
       (5, 3),
       (5, 5),
       (5, 6),
       (5, 7);
insert into location (name, description, room_size)
values ('Studio A', 'Great for fitness, yoga, dance or workout space', 988),
       ('Studio B', 'Floating hardwood floor where pilates, yoga, spin, and a variety of fitness classes are offered.',
        1022),
       ('Studio C', 'Floating hardwood floor where pilates, yoga, spin, and a variety of fitness classes are offered.',
        1730);
insert into class (start_time, end_time, total_capacity, instructor_id, program_id, location_id)
values ('2023-12-16 10:00:00', '2023-12-16 10:45:00', 18, 1, 1, 1),
       ('2023-12-17 12:00:00', '2023-12-17 12:45:00', 18, 1, 2, 1),
       ('2023-12-18 10:00:00', '2023-12-18 10:45:00', 18, 1, 3, 2),
       ('2023-12-19 16:00:00', '2023-12-19 16:45:00', 18, 1, 7, 3),
       ('2023-12-16 11:00:00', '2023-12-16 11:45:00', 18, 2, 2, 1),
       ('2023-12-17 9:00:00', '2023-12-17 9:45:00', 18, 2, 3, 2),
       ('2023-12-19 10:00:00', '2023-12-19 10:45:00', 18, 3, 3, 1),
       ('2023-12-20 10:00:00', '2023-12-20 10:45:00', 18, 3, 4, 1),
       ('2023-12-21 17:00:00', '2023-12-16 17:45:00', 18, 3, 5, 2),
       ('2023-12-17 15:00:00', '2023-12-17 15:45:00', 18, 4, 5, 3),
       ('2023-12-18 15:00:00', '2023-12-18 15:45:00', 18, 5, 3, 1),
       ('2023-12-19 11:00:00', '2023-12-19 11:45:00', 18, 5, 5, 2),
       ('2023-12-20 9:00:00', '2023-12-20 9:45:00', 18, 5, 6, 3),
       ('2023-12-21 9:00:00', '2023-12-21 9:45:00', 18, 5, 7, 1);
insert into booking (person_id, class_id)
values (6, 1),
       (6, 2),
       (6, 3),
       (7, 1),
       (7, 3),
       (7, 5),
       (8, 2),
       (8, 4),
       (8, 6),
       (8, 8),
       (9, 3),
       (9, 6),
       (9, 9),
       (9, 12),
       (10, 5),
       (10, 10),
       (10, 14),
       (11, 2),
       (11, 4),
       (11, 8),
       (11, 11),
       (12, 6),
       (12, 12),
       (12, 13),
       (12, 14),
       (13, 5),
       (13, 6),
       (13, 7),
       (13, 8),
       (14, 7),
       (14, 8),
       (14, 9),
       (15, 5),
       (15, 10),
       (15, 14),
       (16, 11),
       (16, 12),
       (16, 13),
       (16, 14),
       (17, 5),
       (17, 7),
       (17, 9),
       (17, 11),
       (18, 3),
       (18, 6),
       (18, 9),
       (18, 12),
       (18, 13),
       (19, 1),
       (19, 2),
       (19, 3),
       (19, 5),
       (19, 7),
       (19, 11),
       (19, 13);