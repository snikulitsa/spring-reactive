CREATE TABLE IF NOT EXISTS organization
(
    id   BIGSERIAL     NOT NULL PRIMARY KEY,
    name VARCHAR(1023) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee
(
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    name            VARCHAR(1023),
    salary          BIGINT    NOT NULL,
    organization_id BIGINT    NOT NULL
        CONSTRAINT employee_organization_id_fk
            REFERENCES organization
            ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO organization(name)
VALUES ('EPAM'),
       ('LUXOFT'),
       ('CCSSS');

INSERT INTO employee(name, salary, organization_id)
VALUES ('epam_1', 1000, 1),
       ('epam_2', 1100, 1),
       ('epam_3', 1500, 1),
       ('luxoft_1', 900, 2),
       ('luxoft_2', 1200, 2),
       ('luxoft_3', 1300, 2),
       ('oleg', 1500, 3),
       ('maxim', 1000, 3),
       ('sanya', 700, 3);