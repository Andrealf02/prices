-- Create Product Table
CREATE TABLE product (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
);

-- Create Price Table
CREATE TABLE price (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       value DECIMAL(10, 2) NOT NULL,
                       currency VARCHAR(3) NOT NULL,
                       date_time TIMESTAMP NOT NULL,
                       product_id INT NOT NULL,
                       FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Create Store Table
CREATE TABLE store (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL
);

-- Create PriceHistory Table
CREATE TABLE price_history (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               old_value DECIMAL(10, 2) NOT NULL,
                               new_value DECIMAL(10, 2) NOT NULL,
                               old_currency VARCHAR(3) NOT NULL,
                               new_currency VARCHAR(3) NOT NULL,
                               date_time TIMESTAMP NOT NULL,
                               price_id INT NOT NULL,
                               store_id INT NOT NULL,
                               FOREIGN KEY (price_id) REFERENCES price(id),
                               FOREIGN KEY (store_id) REFERENCES store(id)
);
-- File: shopping_prices_schema.sql

-- Create Product Table
CREATE TABLE product (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
);

-- Create Price Table
CREATE TABLE price (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       value DECIMAL(10, 2) NOT NULL,
                       currency VARCHAR(3) NOT NULL,
                       date_time TIMESTAMP NOT NULL,
                       product_id INT NOT NULL,
                       FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Create Store Table
CREATE TABLE store (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL
);

-- Create PriceHistory Table
CREATE TABLE price_history (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               old_value DECIMAL(10, 2) NOT NULL,
                               new_value DECIMAL(10, 2) NOT NULL,
                               old_currency VARCHAR(3) NOT NULL,
                               new_currency VARCHAR(3) NOT NULL,
                               date_time TIMESTAMP NOT NULL,
                               price_id INT NOT NULL,
                               store_id INT NOT NULL,
                               FOREIGN KEY (price_id) REFERENCES price(id),
                               FOREIGN KEY (store_id) REFERENCES store(id)
);
