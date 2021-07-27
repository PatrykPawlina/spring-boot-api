DROP TABLE IF EXISTS ADDRESS CASCADE;
CREATE TABLE ADDRESS
(
    id               LONG AUTO_INCREMENT PRIMARY KEY,
    city             VARCHAR(100) NOT NULL,
    code_postal      VARCHAR(20)  NOT NULL,
    street           VARCHAR(200),
    building_number  BIGINT,
    apartment_number BIGINT
);