DROP TABLE IF EXISTS USER CASCADE;
CREATE TABLE USER
(
    id                 LONG AUTO_INCREMENT PRIMARY KEY,
    gender             ENUM ('MALE','FEMALE') NOT NULL,
    first_name         VARCHAR(250)           NOT NULL,
    last_name          VARCHAR(250)           NOT NULL,
    age                INTEGER                NOT NULL,
    car_id             BIGINT,
    address_id         BIGINT                 NOT NULL,
    driving_license_id BIGINT                 NOT NULL
);