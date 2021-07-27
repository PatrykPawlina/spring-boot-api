DROP TABLE IF EXISTS DRIVING_LICENSE CASCADE;
CREATE TABLE DRIVING_LICENSE
(
    id                       LONG AUTO_INCREMENT PRIMARY KEY,
    driving_license_category VARCHAR(20) NOT NULL,
    number_driving_license   INTEGER     NOT NULL,
    user_id                  BIGINT      NOT NULL
);
