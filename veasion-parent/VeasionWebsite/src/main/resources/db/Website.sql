
-- 创建数据库 veasion_website

-- CREATE DATABASES `veasion_website` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

set FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
drop table if exists test;
create table test (
  id int(11) not null AUTO_INCREMENT,
  name varchar(30) default null,
  primary key (id)
);

-- ----------------------------
-- Records of test
-- ----------------------------
insert into test values (1, 'test...');
