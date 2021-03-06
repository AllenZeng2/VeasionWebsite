
-- 创建数据库 veasion_desktop

-- CREATE DATABASES `veasion_desktop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

set FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for desktop_cloumn
-- ----------------------------
drop table if exists desktop_cloumn;
create table desktop_cloumn (
  id int(11) not null AUTO_INCREMENT,
  url_id int(11) not null,
  title varchar(30) default null,
  icon_id int(11) not null,
  width int(11) default null,
  height int(11) default null,
  show_type int(11) default '0',
  status int(11) default '1',
  create_date datetime default null,
  primary key (id)
);

-- ----------------------------
-- Records of desktop_cloumn
-- ----------------------------
insert into desktop_cloumn values ('1', '35', '我的主页', '1', '900', '700', '0', '1', NOW());
insert into desktop_cloumn values ('2', '36', '电影', '17', '1200', '1200', '0', '1', NOW());
insert into desktop_cloumn values ('3', '37', '记事本', '11', '440', '480', '4', '1', NOW());
insert into desktop_cloumn values ('4', '38', '聊天', '14', '500', '500', '0', '1', NOW());
insert into desktop_cloumn values ('5', '39', '音乐', '19', '750', '600', '0', '1', NOW());
insert into desktop_cloumn values ('6', '40', '游戏', '21', '500', '500', '0', '1', NOW());
insert into desktop_cloumn values ('7', '41', 'QQ', '22', '1100', '600', '0', '1', NOW());
insert into desktop_cloumn values ('8', '42', '搜索', '23', '900', '500', '0', '1', NOW());
insert into desktop_cloumn values ('9', '43', 'Github', '3', '0', '0', '3', '1', NOW());
insert into desktop_cloumn values ('10', '44', '博客', '2', '0', '0', '3', '1', NOW());
insert into desktop_cloumn values ('11', '38', 'Love', '16', '500', '500', '0', '1', NOW());
insert into desktop_cloumn values ('12', '45', '人脸识别', '20', '1200', '650', '0', '1', NOW());
insert into desktop_cloumn values ('13', '46', '文字识别', '10', '1150', '750', '0', '1', NOW());
insert into desktop_cloumn values ('14', '48', '推荐书籍', '47', '1000', '650', '4', '1', NOW());

-- ----------------------------
-- Table structure for desktop_style
-- ----------------------------
drop table if exists desktop_style;
create table desktop_style (
  id int(11) not null AUTO_INCREMENT,
  name varchar(50) default null,
  author varchar(30) default null,
  bgimg_id int(11) not null,
  cloumn_width int(11) default null,
  cloumn_height int(11) default null,
  create_date datetime default null,
  status int(11) default '1',
  primary key (id)
);

-- ----------------------------
-- Records of desktop_style
-- ----------------------------
insert into desktop_style values ('1', '英雄绿风', 'Veasion', '27', '36', '36', NOW(), '1');
insert into desktop_style values ('2', '飞机鸟', 'Veasion', '28', '36', '36', NOW(), '0');
insert into desktop_style values ('3', '小希', 'Veasion', '29', '36', '36', NOW(), '0');

-- ----------------------------
-- Table structure for `desktop_style_cloumn`
-- ----------------------------
drop table if exists `desktop_style_cloumn`;
create table `desktop_style_cloumn` (
  `id` int(11) not null AUTO_INCREMENT,
  `style_id` int(11) not null,
  `cloumn_id` int(11) not null,
  primary key (`id`)
);

-- ----------------------------
-- Records of desktop_style_cloumn
-- ----------------------------
insert into `desktop_style_cloumn` values ('1', '1', '1');
insert into `desktop_style_cloumn` values ('2', '1', '2');
insert into `desktop_style_cloumn` values ('3', '1', '3');
insert into `desktop_style_cloumn` values ('4', '1', '4');
insert into `desktop_style_cloumn` values ('5', '1', '5');
insert into `desktop_style_cloumn` values ('6', '1', '6');
insert into `desktop_style_cloumn` values ('7', '1', '7');
insert into `desktop_style_cloumn` values ('8', '1', '8');
insert into `desktop_style_cloumn` values ('9', '1', '9');
insert into `desktop_style_cloumn` values ('10', '1', '10');
insert into `desktop_style_cloumn` values ('11', '1', '11');
insert into `desktop_style_cloumn` values ('12', '1', '12');
insert into `desktop_style_cloumn` values ('13', '1', '13');
insert into `desktop_style_cloumn` values ('14', '2', '1');
insert into `desktop_style_cloumn` values ('15', '2', '2');
insert into `desktop_style_cloumn` values ('16', '2', '3');
insert into `desktop_style_cloumn` values ('17', '2', '4');
insert into `desktop_style_cloumn` values ('18', '2', '5');
insert into `desktop_style_cloumn` values ('19', '2', '6');
insert into `desktop_style_cloumn` values ('20', '2', '7');
insert into `desktop_style_cloumn` values ('21', '2', '8');
insert into `desktop_style_cloumn` values ('22', '2', '9');
insert into `desktop_style_cloumn` values ('23', '2', '10');
insert into `desktop_style_cloumn` values ('24', '2', '11');
insert into `desktop_style_cloumn` values ('25', '2', '12');
insert into `desktop_style_cloumn` values ('26', '2', '13');
insert into `desktop_style_cloumn` values ('27', '3', '1');
insert into `desktop_style_cloumn` values ('28', '3', '3');
insert into `desktop_style_cloumn` values ('29', '3', '5');
insert into `desktop_style_cloumn` values ('30', '3', '8');
insert into `desktop_style_cloumn` values ('31', '3', '9');
insert into `desktop_style_cloumn` values ('32', '3', '10');
insert into `desktop_style_cloumn` values ('33', '3', '12');
insert into `desktop_style_cloumn` values ('34', '1', '14');
insert into `desktop_style_cloumn` values ('35', '2', '14');
insert into `desktop_style_cloumn` values ('36', '3', '14');

-- ----------------------------
-- Table structure for ip_record
-- ----------------------------
drop table if exists ip_record;
create table ip_record (
  id int(11) not null AUTO_INCREMENT,
  ip varchar(50) not null,
  date datetime default null,
  line int(11) default null,
  area varchar(50) default null,
  primary key (id)
);

-- ----------------------------
-- Records of ip_record
-- ----------------------------

-- ----------------------------
-- Table structure for veasion_music
-- ----------------------------
drop table if exists veasion_music;
create table veasion_music (
  id int(11) not null AUTO_INCREMENT,
  name varchar(255) default null,
  url_id int(11) not null,
  img_id int(11) default null,
  singer varchar(100) default '未知',
  source varchar(100) default '未知',
  click int(11) default '0',
  primary key (id)
);

-- ----------------------------
-- Records of veasion_music
-- ----------------------------
insert into veasion_music values(null, '背景音乐', 50, null, '未知', '本站', 0);

-- ----------------------------
-- Table structure for veasion_url
-- ----------------------------
drop table if exists veasion_url;
create table veasion_url (
  id int(11) not null AUTO_INCREMENT,
  name varchar(50) default null,
  url varchar(300) not null,
  type int(11) not null,
  create_date datetime,
  primary key (id)
);

-- ----------------------------
-- Records of veasion_url
-- ----------------------------
insert into veasion_url values ('1', '我的电脑', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/f6ce6115-e5fe-41b5-bcdd-2d770d69c0e9.png', '3', NOW());
insert into veasion_url values ('2', '博客', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/373ade7a-9f31-4845-9672-dfadbbebd009.png', '3', NOW());
insert into veasion_url values ('3', 'github', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/65350716-68e1-442d-863b-1437aecf9269.jpg', '3', NOW());
insert into veasion_url values ('4', '3D立体', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/4595e091-e870-4dc8-babf-8ecb5c0ac46b.png', '3', NOW());
insert into veasion_url values ('5', '外星人文件夹', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/11671245-8e5b-4738-901f-1378f8ce72fb.png', '3', NOW());
insert into veasion_url values ('6', '数据', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/f3d23bd0-cbda-4a0a-960d-f0ea87d4f96b.png', '3', NOW());
insert into veasion_url values ('7', '日历', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/6db59ef4-9bde-4de3-b0ea-b1b1d0dc32f3.png', '3', NOW());
insert into veasion_url values ('8', '普通文件夹', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/5ed470bc-8207-4901-bb38-856f66435edb.png', '3', NOW());
insert into veasion_url values ('9', '记事本1', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/166ee622-4eb2-499d-9bf6-46eca6a3441f.png', '3', NOW());
insert into veasion_url values ('10', '文章写字', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/9ba7ff86-31db-4b9e-99be-6e37cac1da73.png', '3', NOW());
insert into veasion_url values ('11', '日记', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/c5b918f4-dd5d-4d80-a02c-d7fe17b9ad51.png', '3', NOW());
insert into veasion_url values ('12', '计算器', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/5b5f63fe-78f2-4fa8-9165-bde381b2f7c7.png', '3', NOW());
insert into veasion_url values ('13', '垃圾桶', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/09305ff9-8ed0-4374-bcaa-abccdc830506.png', '3', NOW());
insert into veasion_url values ('14', '聊天', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/2c6e07af-785e-4f6a-ae18-3f9afe6c2c79.png', '3', NOW());
insert into veasion_url values ('15', '聊天2', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/85918d96-5436-4457-823e-4e2b84fb7ef9.png', '3', NOW());
insert into veasion_url values ('16', 'Iloveyou', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/d6bb63bf-03af-47af-a53a-2f28ecf30215.png', '3', NOW());
insert into veasion_url values ('17', '电影', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/f446224e-bded-4bb0-a07e-e2e7fc3f0003.png', '3', NOW());
insert into veasion_url values ('18', '音乐1', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/d1212f71-9b4c-4336-925f-1304bb7b1067.png', '3', NOW());
insert into veasion_url values ('19', '音乐2', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/ffef3ced-7e39-4fb1-9d30-f0e8e7682ddc.png', '3', NOW());
insert into veasion_url values ('20', '相机', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/63fe3eb5-9b2d-44f5-beb6-3ed3c3afc6c0.png', '3', NOW());
insert into veasion_url values ('21', '卡通球', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/d291d200-85f0-41d0-8646-fd76cb381565.png', '3', NOW());
insert into veasion_url values ('22', 'QQ', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/6b9b5e1e-e1c4-463c-b70a-6745b5493092.png', '3', NOW());
insert into veasion_url values ('23', '搜索', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/dfe6ad2f-b6e8-4360-a395-97f99aefa253.png', '3', NOW());
insert into veasion_url values ('24', '工具', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/5aa3c0b8-99f1-418a-bf7d-ea0ad191029e.png', '3', NOW());
insert into veasion_url values ('25', '羊皮纸', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/8b3f2617-1a1a-4db3-8792-16e489a2a080.png', '3', NOW());
insert into veasion_url values ('26', '龙龟', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/229fa0c1-397f-4592-99a5-d0f421b2ad6b.jpg', '2', NOW());
insert into veasion_url values ('27', '绿鬼法师', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/6ec0dc59-1203-4fe0-88e0-1446f0bb707f.jpg', '2', NOW());
insert into veasion_url values ('28', '飞机鸟', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/a5ff6ba5-af33-414a-8cb8-49d7b3ad0515.jpg', '2', NOW());
insert into veasion_url values ('29', '小希', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/e9b1ec5f-d9b6-4e92-8ec6-16decb01c3bc.jpg', '2', NOW());
insert into veasion_url values ('30', '跑车', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/45962c6e-861f-4f7d-b40b-cd84f1dbeded.jpg', '2', NOW());
insert into veasion_url values ('31', '水滴', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/f3412719-2850-4d39-832e-5517422de13c.jpg', '2', NOW());
insert into veasion_url values ('32', 'Mac', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/037dd7ac-33a9-4553-a6e7-eb38d585469b.jpg', '2', NOW());
insert into veasion_url values ('35', '我的主页', '/VeasionWebsite/home/desktop/index', '1', NOW());
insert into veasion_url values ('36', '优酷电影', 'http://www.youku.com/', '1', NOW());
insert into veasion_url values ('37', '记事本', '/VeasionWebsite/webpage/home/desktop/notepad.jsp', '1', NOW());
insert into veasion_url values ('38', '#', '#', '1', NOW());
insert into veasion_url values ('39', '酷狗音乐', 'http://web.kugou.com/', '1', NOW());
insert into veasion_url values ('40', '4399', 'http://www.4399.com/', '1', NOW());
insert into veasion_url values ('41', 'QQ', 'http://w.qq.com/', '1', NOW());
insert into veasion_url values ('42', '百度', 'http://www.baidu.com', '1', NOW());
insert into veasion_url values ('43', '我的Github', 'https://github.com/veasion', '1', NOW());
insert into veasion_url values ('44', '我的博客', 'http://59.110.241.52/solo', '1', NOW());
insert into veasion_url values ('45', '真人秀之人脸识别', '/VeasionWebsite/webpage/home/desktop/face/faceImage.jsp', '1', NOW());
insert into veasion_url values ('46', '文字识别', '/VeasionWebsite/webpage/home/desktop/face/faceText.jsp', '1', NOW());
insert into veasion_url values ('47', '看书1', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/94b04854-646f-4fd0-93b7-e8bbf55c1c2a.png', '3', NOW());
insert into veasion_url values ('48', '推荐书籍', '/VeasionWebsite/webpage/home/desktop/book/book.jsp', '1', NOW());
insert into veasion_url values ('49', '看书2', 'http://veasion.oss-cn-shanghai.aliyuncs.com/images/eff4f7af-01e1-43bd-b51a-58de513b4a2b.png', '3', NOW());
insert into veasion_url values ('50', '背景音乐', '/VeasionWebsite/resources/other/bgsound.mp3', '4', NOW());

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
drop table if exists dictionary;
create table dictionary (
  id int(11) not null AUTO_INCREMENT,
  type int(11) not null,
  value varchar(200) not null,
  status int(11) default '1',
  create_date datetime,
  primary key (id)
);

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (null, '1', 'Veasion', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '2', 'Veasion', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '经检测此人帅到爆表！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '检测发生系统故障！可能是他太帅~', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '他的是我的工程师Veasion', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '帅气值：100%', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '这么帅，你可以靠脸吃饭了!', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '你是我见过最帅的一个', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '颜值爆表！！！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '小伙子很有前途！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '你不得了！,颜值爆表', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '魅力已超上线，系统故障！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '此人人值超凡！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '他的名字叫Veasion，我的工程师爸爸！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '卓越又伟大用来形容你刚刚好！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '小伙是块上等好料', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '我能猜到你是我的工程师爸爸！', '1', NOW());
INSERT INTO `dictionary` VALUES (null, '3', '我能猜到你是我的工程师爸爸！', '1', NOW());

-- ----------------------------
-- Table structure for key_value
-- ----------------------------
drop table if exists key_value;
create table key_value (
  name varchar(100) primary key not null,
  value varchar(200) default null,
  status int(11) default '1'
);

insert into key_value values('autograph', '做更好的自己，加油！', 1);
insert into key_value values('upvoteCount', '0', 1);
