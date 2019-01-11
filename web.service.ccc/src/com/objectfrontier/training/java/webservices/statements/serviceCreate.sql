CREATE TABLE service_address (
    PRIMARY KEY (id),
    id          BIGINT(20)   AUTO_INCREMENT,
    street      VARCHAR(100) NOT NULL,
    city        VARCHAR(15)  NOT NULL,
    postal_code INT(11)      NOT NULL
);

CREATE TABLE service_person_ccc (
    PRIMARY KEY (id),
    id           BIGINT(20)   AUTO_INCREMENT,
    first_name   VARCHAR(50)  NOT NULL,
    last_name    VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    address_id   BIGINT(20),
    birth_date   DATE         NOT NULL,
    created_date DATETIME     NOT NULL,
    `password`   VARCHAR(15)  NOT NULL,
	is_admin     BOOLEAN      NOT NULL,
                 KEY k_service_person_ccc_address_id (address_id),
                 CONSTRAINT fk_service_person_ccc_service_address
                 FOREIGN KEY (address_id) REFERENCES service_address (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);