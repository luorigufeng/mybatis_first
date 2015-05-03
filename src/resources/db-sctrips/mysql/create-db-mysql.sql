USE MYBATIS;

DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) DEFAULT NULL,
  `userAge` INT(11) DEFAULT NULL,
  `userAddress` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `userid` INT(11) NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=UTF8;


-- test data 
INSERT INTO `USER` VALUES ('1', 'summer', '100', 'shanghai,pudong');

Insert INTO `article` VALUES ('1', '1', 'test_title', 'test_content');
Insert INTO `article` VALUES ('2', '1', 'test_title_2', 'test_content_2');
Insert INTO `article` VALUES ('3', '1', 'test_title_3', 'test_content_3');
Insert INTO `article` VALUES ('4', '1', 'test_title_4', 'test_content_4');