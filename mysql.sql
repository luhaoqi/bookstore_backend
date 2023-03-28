create
DATABASE mybookstore;

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`
(
    `bid`    int NOT NULL AUTO_INCREMENT,
    `name`   varchar(100) DEFAULT NULL,
    `author` varchar(100) DEFAULT NULL,
    `price`  varchar(100) DEFAULT NULL,
    `image`  varchar(100) DEFAULT NULL,
    `sales`  int          DEFAULT 0,
    PRIMARY KEY (`bid`)
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `uid`      int NOT NULL AUTO_INCREMENT,
    `username` varchar(100) DEFAULT NULL,
    `password` varchar(100) DEFAULT NULL,
    `email`    varchar(100) DEFAULT NULL,
    `tel`      varchar(100) DEFAULT NULL,
    `address`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`uid`)
);

INSERT INTO mybookstore.users (name, password, email, tel, address)
VALUES ('lhq', 'qwerty', '1171821456@qq.com', '13736111836', 'SJTU')

DROP TABLE IF EXISTS `order_lists`;
CREATE TABLE `order_lists`
(
    `order_list_id` int NOT NULL AUTO_INCREMENT,
    `price`         varchar(100) DEFAULT NULL,
    `time`          varchar(100) DEFAULT NULL,
    `uid`           int,
    PRIMARY KEY (`order_list_id`),
    FOREIGN KEY (uid) REFERENCES users (uid)
);

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`
(
    `order_item_id` int NOT NULL AUTO_INCREMENT,
    `bid`           int,
    `order_list_id` int,
    PRIMARY KEY (`order_item_id`),
    FOREIGN KEY (bid) REFERENCES books (bid),
    FOREIGN KEY (order_list_id) REFERENCES order_lists (order_list_id)
);

DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`
(
    `cart_id` int NOT NULL AUTO_INCREMENT,
    `price`   varchar(100) DEFAULT NULL,
    `user_id` int,
    PRIMARY KEY (`cart_id`),
    FOREIGN KEY (user_id) REFERENCES users (uid)
);

create
database test;