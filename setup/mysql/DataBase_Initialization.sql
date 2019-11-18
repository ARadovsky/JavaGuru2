CREATE TABLE IF NOT EXISTS products(
    id          BIGINT          NOT NULL    AUTO_INCREMENT,
    name        VARCHAR(100)    NOT NULL,
    description VARCHAR(200)    NULL,
    category    VARCHAR(100)    NULL,
    price       DOUBLE          NOT NULL,
    discount    DOUBLE          NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE=InnoDB
    AUTO_INCREMENT=1;