/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 27/03/2023 20:29:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bid` int NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales` int NOT NULL,
  `stock` int NOT NULL,
  `flag` int NOT NULL,
  `kind` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, '梁晓声', '《人世间》（三卷本）是著名作家梁晓声饱含深情的鸿篇巨著，展现了作家丰厚的生活积累和健旺的创作活力，标志着梁晓声现实主义小说创作的新高度。《人世间》以北方某省会城市一个平民区——共乐区为背景，刻画了从这里走出的十几位平民子弟跌宕起伏的人生，展示波澜壮阔的中国社会巨变。从二十世纪七十年代初至改革开放后的今天，他们有的通过读书奋斗改变命运成为社会精英，更多的则像父辈那样努力打拼辛劳谋生。人物的性格命运各有不同，善良正直、自尊自强、勤劳坚忍、互助相帮的人性幽微之光却永远闪耀，梦想的力量荡气回肠。这是一部关于磨难、奋斗、担当和友情的小说，平民视角，悲悯情怀，纵横交错的复式结构，通过一个个可亲可感的人物全景展示中国社会的发展进程，让小说具有了社会生活的史诗品格。', 'http://img3m3.ddimg.cn/5/1/25207583-1_u_12.jpg', '9787515350264', '人世间', '23800', 12, 22, 0, '小说');
INSERT INTO `books` VALUES (2, '罗伯特·戴博德', '　　蛤蟆先生一向爱笑爱闹，如今却一反常态地郁郁寡欢。他一个人躲在屋里，连起床梳洗的力气都没有。朋友们非常担心他，建议他去做心理咨询。在10次心理咨询中，蛤蟆在咨询师苍鹭的带领下，勇敢地探索了自己的内心世界，也逐渐找回了信心与希望……\n　　为了向大众读者普及心理学知识，告诉大家心理咨询是怎么一回事，作者借用了英国文学经典《柳林风声》的故事主角，让蛤蟆先生和他的朋友们再次登场，演绎了这个关于心理咨询的故事。读者犹如亲临现场，体验心理咨询的每一个细节，见证疗愈和改变的发生。\n　　在这本书里，作者借由蛤蟆和心理咨询师苍鹭的互动，探索了蛤蟆自卑、软弱、爱炫耀的个性与抑郁的情绪究竟来源于何处，让读者看到童年经历的深刻影响，以及如何才能在心理上真正长大成人，独立、自信、充满希望地生活。', 'http://img3m9.ddimg.cn/71/33/28992419-1_u_52.jpg', '9787201161693', '蛤蟆先生去看心理医生', '3800', 24, 24, 1, '心理学');
INSERT INTO `books` VALUES (3, '豆豆', '《遥远的救世主》\n　　也是一部可遇不可求的完美佳作。\n　　豆豆，以她的才华，探部一个有机的、无定形的、陌生的、暧昧的和未曾臻达的世界。男女主人公那浓墨重彩的经历以及令人欷歔的爱情故事创造出了一种超然背叛的意志、而这意志是那样的静谧、清明。\n　　丁元英，这位传统文化的叛逆者在柏林私募基金分红会议上突然宣布私募基金解散，结束了他在法律真空地带利用文化密码对中国股市屠杀性掠取，孑孑一人回到中国某古城隐居下来。\n　　芮小丹，一位从小在法兰克福长大的中国女了，侨居异国的边缘感使她对主流社会充满了天然的渴求，刑警的职业使她与丁无英不期而遇……\n　　俩人从音响发烧友变成爱情发烧友，直到迎接那冲天的光焰……\n　　一个作家的品质，在豆豆身上达到了极至，作品主题的睿智和简约，出色地表现出佛学光耀和不蓄意的使人震惊！', 'http://img3m2.ddimg.cn/85/9/29365762-1_u_1.jpg', '9787506331746', '遥远的救世主', '4800', 15, 41, 1, '小说');
INSERT INTO `books` VALUES (4, '希阿荣博堪布', '《次第花开》是希阿荣博堪布所写的心灵随笔集，以现代人的思维和表达方式，将心灵世界应有的美好境界娓娓道来。\n\n本书就像是一个忠实的朋友，在迷茫脆弱的时候，给我们以鼓励和启发，让我们生起对三宝和佛法的信心以及求解脱的决心。\n\n书中处处散发着慈悲与智慧的光芒，堪布睿智柔和的文字，朴实生动的开示，帮助我们坦然地面对心的本性，并从各种困惑中解脱出来，获得重塑心灵世界的力量。', 'http://img3m4.ddimg.cn/67/33/24184084-1_u_9.jpg', '9787515350265', '次第花开 修订版', '3980', 13, 56, 1, '哲学');
INSERT INTO `books` VALUES (5, '莫言', '五十年间西门闹经历六次转世，\n\n一世为驴，二世为牛，三世为猪，四世为狗，五世为猴，终降生为人。\n\n在这六世里，他目睹蓝脸一家三代经历人生的生死疲劳，\n\n他们爱就爱到底，恨就恨到底，犟就犟到底，干就干到底，\n\n有极致的痛苦与欢乐，更有不灭的热情与希望。\n\n而他们的故事，要从1950年1月1日讲起……', 'http://img3m5.ddimg.cn/37/23/29343835-1_u_18.jpg', '9787515350266', '生死疲劳', '6990', 12, 20, 1, '小说');
INSERT INTO `books` VALUES (6, '余华', '《活着》是当代作家余华的代表作，讲述了一个人历尽世间沧桑和磨难的一生，亦将中国大半个世纪的社会变迁凝缩其间。《活着》还讲述了眼泪的宽广和丰富；讲述了绝望的不存在；讲述了人是为了活着本身而活着的，而不是为了活着之外的任何事物而活着。', 'http://img3m3.ddimg.cn/23/25/29311943-1_u_29.jpg', '9787515350267', '活着（精装）', '4500', 6, 18, 1, '小说');
INSERT INTO `books` VALUES (35, '(法) 圣埃克苏佩里、郑克鲁译', '外星人在哪里？小王子就是呀！\n\n纯洁、忧郁的小王子，来自宇宙间某个不为人知的小星球。他与一位飞行员在撒哈拉沙漠相遇，攀谈中，小王子的秘密逐渐揭开，他是因为与美丽而骄傲的玫瑰发生了感情上的矛盾，才负气出走的。星际漫游中，小王子造访了六个星球，却没有找到一个朋友。在地理学家的建议下，他来到了地球，收获了狐狸的友谊，也从狐狸那里学会了人生真谛。*重要的是，他终于懂得了玫瑰的花招背后所隐藏的无限柔情，于是决定回归星球，回到玫瑰身边。在一条毒蛇的帮助下，小王子消失天际，飞行员再也没有见过这个可爱的小人儿了……', 'http://img3m6.ddimg.cn/34/34/25289386-1_u_24.jpg', '9787517827122', '小王子', '1222', 27, 29, 1, '童话');
INSERT INTO `books` VALUES (36, '哈珀·李', ' 美国电影协会评选的“100名银幕英雄与恶人”中，派克主演的芬奇律师名列英雄首位。\n　　成长总是个让人烦恼的命题。成长有时会很缓慢，如小溪般唱着叮咚的歌曲趟过，有时却如此突如其来，如暴雨般劈头盖脸……三个孩子因为小镇上的几桩冤案经历了猝不及防的成长——痛苦与迷惑，悲伤与愤怒，也有温情与感动。这是爱与真知的成长经典。\n哈珀·李所作的《杀死一只知更鸟(精)》的故事发生在大萧条时期美国南方一个静谧的小镇，几桩离奇的疑案彻底打破了几个孩子平静的生活：事件的真凶，怪人的谜底，传言背后的真相……在父亲的指引下，他们在迷雾中寻找真知，在磨难中历练风度，在不公平中积累正气，经历了暴风骤雨般的成长，也感受了人间的温暖与真情。\n《杀死一只知更鸟》获1960年普利策奖。\n　　美国图书馆借阅率*的书之一，英国青少年喜爱的小说之一。\n　　美国中学推荐课外读物。', 'http://img3m2.ddimg.cn/1/34/24185602-1_u_25040.jpg', '9787544766500', '杀死一只知更鸟', '4800', 24, 53, 1, '小说');
INSERT INTO `books` VALUES (40, '路遥', '《平凡的世界（全三部）》是路遥的长篇代表作，曾获第三届茅盾文学奖，并入选“新中国70年70部长篇小说典藏”，得到各界名家的一致推荐。\n\n《平凡的世界（全三部）》是一段平凡却热血、温暖又动人的成长故事，小说以孙少平与孙少安两兄弟为主角，讲述他们在生活中面临重重困难与挑战，却依然无畏前行的人生历程。《平凡的世界》深刻展示了普通人在大时代中走过的平凡却不平庸的道路，细腻书写亲情、爱情和友情，饱含真善美和昂扬向上的力量，今天读来依然让人充满共鸣，更给人以激励。《平凡的世界》也是一部跨时代的经典，在反映时代的同时超_越时代，散发出经久不衰的魅力。', 'http://img3m4.ddimg.cn/34/12/29253544-1_u_16.jpg', '9787530221396', '平凡的世界：全三册', '9800', 30, 51, 1, '小说');
INSERT INTO `books` VALUES (43, '罗广斌，杨益言', '小说发生在1948年至1949年解放战争时期，蒋介石集团反动统治*黑暗日子里的山城重庆。黎明时刻，我党的活动比任何时期都要活跃，敌人的镇压迫害也比任何时期残酷，因而敌我双方*后这场决战，显得异常激烈。为了配合工人运动，重庆地下党工人运动书记许云峰命甫志高建立沙坪书店，作为地下党的备用联络站。江姐受上级派遣到华蓥山根据地送药品。当她正满怀憧憬地想象未来的生活时，却发现自己的丈夫——华蓥山纵队政委彭松涛被敌人杀害，人头被高挂在城头。见到纵队司令员“双枪老太婆”后，她强忍悲痛，坚决要求到丈夫生前战斗的地方工作。甫志高被捕并成了可耻的叛徒，由于他的告密，许云峰、成岗、余新江和刘思扬等人很快相继被捕。甫志高又带领特务窜到乡下，江姐不幸被捕，被关押在渣滓洞里。在狱中，她受尽了折磨，凶残的敌人把竹签钉进了她的十指。面对毒刑，她傲然宣告： “毒刑拷打是太小的考验，竹签子是竹做的，共产党员的意志是钢铁。”秋去冬来，转眼到了年底。全国革命形势一片大好，敌人为了表示和谈的“诚意”，假意释放了一些政治犯，来自资本家家庭的共产党员刘思扬就是其中之一。郑克昌奉命诱骗刘思扬，在任务失败后，又伪装成同情革命的记者高邦晋打入渣滓洞，他妄图通过苦肉计刺探狱中地下党的秘密。余新江等人识破了他的伪装，并借他之手除掉了阴险的特务。当解放军攻入四川，即将解放重庆的时候，徐鹏飞等狗急跳墙，提前秘密杀害了许云峰、江姐、成岗等人。就在许云峰等人被害的当天晚上，渣滓洞和白公馆同时举行了暴动。刘思扬等一些同志牺牲了，但更多的同志终于冲出了魔窟，伴随着解放军隆隆的炮声，去迎接黎明时灿烂的曙光！ 作者以一定的广度和深度再现了国民党统治行将覆灭、解放战争走向全国胜利的斗争形势和时代风貌，成功地塑造了许云峰、江姐、成岗和华子良等为代表的共产党人的英雄形象，同时对反面人物的形象塑造也很有特色，既揭示了他们的反动本质，又不流于脸谱化。作品结构错综复杂又富于变化，善于刻画人物心理活动和烘托气氛，语言朴实，笔调悲壮，被誉为“革命的教科书”。作品一经面世，立即引起轰动，先后被改编成电影《烈火中永生》和豫剧《江姐》等，从1961年出版以来，雄踞我国红色经典作品*数十载，激励了无数青年的爱国情怀和奋斗热情。入选中央宣传部、、共青团中央向全国青少年的百种优秀图书。', 'http://img3m1.ddimg.cn/79/2/25167661-1_u_6.jpg', '9787500601593', '红岩', '2270', 20, 61, 1, '小说');
INSERT INTO `books` VALUES (46, '岸見一郎, 古賀史健', '一名深陷自卑、无能与不幸福的青年，听到了一名哲人主张的“世界无比单纯，人人都能幸福”便来挑战，两人展开了你来我往的思考和辩论，在一夜一夜过去后，青年开始思考，为什么“所谓的自由，就是被别人讨厌”？问题不在于世界是什么样子，在于你是什么样子。', 'http://img3m2.ddimg.cn/33/26/28518072-1_u_8.jpg', '23579654', '被讨厌的勇气', '5390', 14, 85, 1, '成功学');
INSERT INTO `books` VALUES (47, '刘慈欣', '文化大革命如火如荼进行的同时，军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。\n\n地球文明向宇宙发出的*声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……\n\n \n\n四光年外，“三体文明”正苦苦挣扎——三颗无规则运行的太阳主导下的百余次毁灭与重生逼迫他们逃离母星。而恰在此时，他们接收到了地球发来的信息。\n\n在运用超技术锁死地球人的基础科学之后，三体人庞大的宇宙舰队开始向地球进发……人类的末日悄然来临。', 'http://img3m4.ddimg.cn/32/35/23579654-1_u_6.jpg', '23579654', '三体', '4470', 5, 91, 1, '科幻');
INSERT INTO `books` VALUES (61, '林语堂', '本书是一部传记，讲述了苏东坡是一个秉性难改的乐天派，是悲天悯人的道德家，是散文作家，是新派的画家，是伟大的书法家，是酿酒的实验者，是工程师，是假道学的反对派，是瑜伽术的修炼者，是佛教徒，是士大夫，是皇帝的秘书，是饮酒成性者，是心肠慈悲的法官，是政治上的坚持己见者，是月下的漫步者，是诗人，是生性诙谐爱开玩笑的人。从各个方面讲述了苏东坡的全部。本书内容详实，图文并茂，值得读者收藏。', 'http://img3m8.ddimg.cn/40/0/25211578-1_u_19.jpg', '9787540484880', '苏东坡传', '5090', 6, 32, 1, '传记');
INSERT INTO `books` VALUES (114, '加西亚·马尔克斯', '《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。作品融入神话传说、民间故事、宗教典故等因素，巧妙地糅合了现实与虚幻，展现出一个瑰丽的想象世界，成为20世纪重要的经典文学巨著。1982年加西亚·马尔克斯获得诺贝尔文学奖，奠定世界文学大师的地位，很大程度上便是凭借《百年孤独》的巨大影响。', 'http://img3m6.ddimg.cn/83/20/25138856-1_u_6.jpg', '9787544291170', '百年孤独', '3960', 81, 30, 1, '小说');

-- ----------------------------
-- Table structure for cart_items
-- ----------------------------
DROP TABLE IF EXISTS `cart_items`;
CREATE TABLE `cart_items`  (
  `cart_item_id` int NOT NULL,
  `bid` int NOT NULL,
  `uid` int NOT NULL,
  `num` int NOT NULL,
  `cart_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`) USING BTREE,
  INDEX `bid`(`bid` ASC) USING BTREE,
  INDEX `uid`(`uid` ASC) USING BTREE,
  INDEX `FKpcttvuq4mxppo8sxggjtn5i2c`(`cart_id` ASC) USING BTREE,
  CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `books` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_items_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKpcttvuq4mxppo8sxggjtn5i2c` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`cart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_items
-- ----------------------------
INSERT INTO `cart_items` VALUES (239, 2, 1, 2, NULL);
INSERT INTO `cart_items` VALUES (240, 3, 1, 3, NULL);
INSERT INTO `cart_items` VALUES (241, 36, 1, 1, NULL);
INSERT INTO `cart_items` VALUES (242, 40, 1, 2, NULL);
INSERT INTO `cart_items` VALUES (243, 35, 1, 1, NULL);
INSERT INTO `cart_items` VALUES (244, 61, 1, 1, NULL);
INSERT INTO `cart_items` VALUES (245, 114, 1, 1, NULL);

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `cart_id` int NOT NULL,
  `price` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE,
  UNIQUE INDEX `UK_64t7ox312pqal3p7fg9o503c2`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FKb5o626f86h46m4s7ms6ginnop` FOREIGN KEY (`user_id`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (246);

-- ----------------------------
-- Table structure for order_items
-- ----------------------------
DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`  (
  `order_item_id` int NOT NULL,
  `num` int NOT NULL,
  `bid` int NOT NULL,
  `order_list_id` int NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`order_item_id`) USING BTREE,
  INDEX `FKin1q0xhd1x9dh98xpdpbw8h5t`(`bid` ASC) USING BTREE,
  INDEX `FK5xafa2tuafgqaxdo518wm6lfl`(`order_list_id` ASC) USING BTREE,
  CONSTRAINT `FK5xafa2tuafgqaxdo518wm6lfl` FOREIGN KEY (`order_list_id`) REFERENCES `order_lists` (`order_list_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKin1q0xhd1x9dh98xpdpbw8h5t` FOREIGN KEY (`bid`) REFERENCES `books` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_items
-- ----------------------------
INSERT INTO `order_items` VALUES (8, 1, 2, 7, 3800);
INSERT INTO `order_items` VALUES (9, 1, 3, 7, 4800);
INSERT INTO `order_items` VALUES (10, 1, 2, 13, 3800);
INSERT INTO `order_items` VALUES (11, 1, 3, 8, 4800);
INSERT INTO `order_items` VALUES (12, 1, 2, 8, 3800);
INSERT INTO `order_items` VALUES (75, 2, 3, 74, 4800);
INSERT INTO `order_items` VALUES (76, 2, 2, 74, 3800);
INSERT INTO `order_items` VALUES (77, 1, 1, 74, 23800);
INSERT INTO `order_items` VALUES (78, 1, 5, 74, 6990);
INSERT INTO `order_items` VALUES (79, 4, 4, 74, 3980);
INSERT INTO `order_items` VALUES (82, 1, 3, 81, 4800);
INSERT INTO `order_items` VALUES (85, 1, 3, 84, 4800);
INSERT INTO `order_items` VALUES (91, 2, 1, 90, 23800);
INSERT INTO `order_items` VALUES (92, 2, 2, 90, 3800);
INSERT INTO `order_items` VALUES (93, 1, 3, 90, 4800);
INSERT INTO `order_items` VALUES (96, 1, 3, 95, 4800);
INSERT INTO `order_items` VALUES (99, 1, 3, 98, 4800);
INSERT INTO `order_items` VALUES (103, 2, 2, 102, 3800);
INSERT INTO `order_items` VALUES (109, 3, 2, 108, 3800);
INSERT INTO `order_items` VALUES (110, 3, 6, 108, 4500);
INSERT INTO `order_items` VALUES (113, 3, 4, 112, 3980);
INSERT INTO `order_items` VALUES (120, 4, 43, 119, 2270);
INSERT INTO `order_items` VALUES (121, 3, 40, 119, 9800);
INSERT INTO `order_items` VALUES (122, 1, 46, 119, 5390);
INSERT INTO `order_items` VALUES (123, 2, 114, 119, 3960);
INSERT INTO `order_items` VALUES (127, 1, 61, 126, 5090);
INSERT INTO `order_items` VALUES (128, 3, 47, 126, 4470);
INSERT INTO `order_items` VALUES (134, 2, 1, 133, 23800);
INSERT INTO `order_items` VALUES (135, 3, 5, 133, 6990);
INSERT INTO `order_items` VALUES (136, 2, 43, 133, 2270);
INSERT INTO `order_items` VALUES (137, 1, 61, 133, 5090);
INSERT INTO `order_items` VALUES (143, 1, 1, 142, 23800);
INSERT INTO `order_items` VALUES (144, 3, 35, 142, 1222);
INSERT INTO `order_items` VALUES (148, 1, 1, 147, 23800);
INSERT INTO `order_items` VALUES (149, 1, 2, 147, 3800);
INSERT INTO `order_items` VALUES (155, 1, 2, 154, 3800);
INSERT INTO `order_items` VALUES (161, 1, 3, 160, 4800);
INSERT INTO `order_items` VALUES (162, 1, 35, 160, 1222);
INSERT INTO `order_items` VALUES (163, 1, 1, 160, 23800);
INSERT INTO `order_items` VALUES (170, 1, 3, 169, 4800);
INSERT INTO `order_items` VALUES (173, 1, 4, 172, 3980);
INSERT INTO `order_items` VALUES (176, 1, 2, 175, 3800);
INSERT INTO `order_items` VALUES (179, 1, 35, 178, 1222);
INSERT INTO `order_items` VALUES (182, 1, 2, 181, 3800);
INSERT INTO `order_items` VALUES (185, 1, 3, 184, 4800);
INSERT INTO `order_items` VALUES (188, 1, 2, 187, 3800);
INSERT INTO `order_items` VALUES (191, 1, 4, 190, 3980);
INSERT INTO `order_items` VALUES (194, 1, 3, 193, 4800);
INSERT INTO `order_items` VALUES (197, 1, 6, 196, 4500);
INSERT INTO `order_items` VALUES (200, 1, 3, 199, 4800);
INSERT INTO `order_items` VALUES (203, 1, 2, 202, 3800);
INSERT INTO `order_items` VALUES (206, 1, 3, 205, 4800);
INSERT INTO `order_items` VALUES (209, 1, 4, 208, 3980);
INSERT INTO `order_items` VALUES (212, 1, 36, 211, 4800);
INSERT INTO `order_items` VALUES (215, 1, 3, 214, 4800);
INSERT INTO `order_items` VALUES (218, 1, 3, 217, 4800);
INSERT INTO `order_items` VALUES (221, 1, 2, 220, 3800);
INSERT INTO `order_items` VALUES (224, 1, 2, 223, 3800);
INSERT INTO `order_items` VALUES (227, 1, 2, 226, 3800);
INSERT INTO `order_items` VALUES (231, 1, 2, 230, 3800);
INSERT INTO `order_items` VALUES (233, 1, 6, 232, 4500);

-- ----------------------------
-- Table structure for order_lists
-- ----------------------------
DROP TABLE IF EXISTS `order_lists`;
CREATE TABLE `order_lists`  (
  `order_list_id` int NOT NULL,
  `price` int NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`order_list_id`) USING BTREE,
  INDEX `FKq5a1fkalw9p0uwf3uel1efhg9`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FKq5a1fkalw9p0uwf3uel1efhg9` FOREIGN KEY (`user_id`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_lists
-- ----------------------------
INSERT INTO `order_lists` VALUES (7, 8600, '2022-05-14 11:18:05', 1, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (8, 8600, '2022-05-16 11:18:05', 1, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (13, 3800, '2022-05-15 16:03:35', 2, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (74, 63910, '2022-07-06 23:55:38', 1, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (81, 4800, '2022-07-07 00:06:05', 1, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (84, 4800, '2022-07-07 00:33:24', 1, '13712345678', '上海交通大学西xx宿舍', 'lhq');
INSERT INTO `order_lists` VALUES (90, 60000, '2022-07-07 21:28:29', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (95, 4800, '2022-07-07 21:34:03', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (98, 4800, '2022-07-07 21:36:41', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (102, 7600, '2022-07-07 22:20:20', 1, '13712345678', 'yyhs', 'LHQ');
INSERT INTO `order_lists` VALUES (108, 24900, '2022-07-08 02:14:21', 56, '13712345678', '上海徐汇', 'newuser');
INSERT INTO `order_lists` VALUES (112, 11940, '2022-07-08 02:14:46', 56, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (119, 51790, '2022-07-08 22:51:35', 3, '13712345678', '浦东', 'wjr');
INSERT INTO `order_lists` VALUES (126, 18500, '2022-07-08 22:52:35', 3, '13712345678', '上海交通大学', 'wjr');
INSERT INTO `order_lists` VALUES (133, 78200, '2022-07-08 22:53:33', 48, '13712345678', '上海交通大学', 'tzm');
INSERT INTO `order_lists` VALUES (142, 27466, '2022-07-09 10:50:57', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (147, 27600, '2022-09-25 23:38:14', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (154, 3800, '2022-09-25 23:59:59', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (160, 29822, '2022-10-01 15:36:44', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (166, 0, '2022-10-02 19:28:55', 1, '13712345678', 'SJTU', 'test8');
INSERT INTO `order_lists` VALUES (167, 0, '2022-10-02 19:31:03', 1, '13712345678', 'SJTU', 'test9');
INSERT INTO `order_lists` VALUES (169, 4800, '2022-10-02 19:56:13', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (172, 3980, '2022-10-02 19:57:36', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (175, 3800, '2022-10-02 19:59:50', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (178, 1222, '2022-10-02 20:01:17', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (181, 3800, '2022-10-02 20:05:12', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (184, 4800, '2022-10-02 20:19:26', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (187, 3800, '2022-10-02 20:23:59', 1, '13712345678', '上海交通大学', 'lhq');
INSERT INTO `order_lists` VALUES (190, 3980, '2022-10-02 20:28:42', 1, '13712345678', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (193, 4800, '2022-10-02 20:29:36', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (196, 4500, '2022-10-02 20:30:01', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (199, 4800, '2022-10-02 20:43:09', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (202, 3800, '2022-10-17 20:47:54', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (205, 4800, '2022-10-18 00:07:56', 1, '13736111836', '上海交通大学', 'luhaoqi');
INSERT INTO `order_lists` VALUES (208, 3980, '2022-10-18 00:46:13', 1, '13736111836', '上海交通大学', '大物1历年期末卷合集');
INSERT INTO `order_lists` VALUES (211, 4800, '2022-10-18 00:50:05', 1, '13736111836', '上海交通大学', 'luhaoqi');
INSERT INTO `order_lists` VALUES (214, 4800, '2022-10-18 00:51:50', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (217, 4800, '2022-10-18 00:52:30', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (220, 3800, '2022-10-18 00:53:49', 1, '13736111836', 'yyhs', '66lhq');
INSERT INTO `order_lists` VALUES (223, 3800, '2022-10-18 01:00:29', 1, '13736111836', 'yyhs', 'lhq');
INSERT INTO `order_lists` VALUES (226, 3800, '2022-10-18 01:03:32', 1, '13736111836', 'yyhs', '66lhq');
INSERT INTO `order_lists` VALUES (230, 3800, '2022-10-18 01:05:27', 2, '123123', 'SJTU', 'asdasd');
INSERT INTO `order_lists` VALUES (232, 4500, '2022-11-05 10:43:36', 1, '13736111836', '上海交通大学', 'cus');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int NOT NULL,
  `login_state` int NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'SJTU', '1171153987@qq.com', 'lhq', 'qwerty', '13712345678', 1, 0);
INSERT INTO `users` VALUES (2, 'SJTU', '1171153987@qq.com', 'HaoqiLu', '123456', '13712345678', 1, 0);
INSERT INTO `users` VALUES (3, 'SJTU', 'wjr@sjtu.edu.cn', 'wjr', 'poiuyt', '13712345678', 1, 0);
INSERT INTO `users` VALUES (4, 'SJTU', 'wjr@sjtu.edu.cn', 'wjr2', 'poiuyt', '13951258742', 0, 0);
INSERT INTO `users` VALUES (12, 'SJTU', 'tzm@sjtu.edu.cn', 'tzm', 'tzm', '13756984516', 0, 0);
INSERT INTO `users` VALUES (13, 'SJTU', '1171153987@qq.com', 'admin', 'admin', '13712345678', 2, 0);
INSERT INTO `users` VALUES (48, 'SJTU', 'tzm@sjtu.edu.cn', 'tzm2', 'tzm2', '13712345678', 1, 0);
INSERT INTO `users` VALUES (54, '', '1171153987@qq.com', 'luhaoqi', 'luhaoqi', '13712345678', 1, 0);
INSERT INTO `users` VALUES (56, '', 'newuser@qq.com', 'newuser', 'newuser', '13712345678', 1, 0);
INSERT INTO `users` VALUES (59, 'TEST', 'test@sjtu.edu.cn', 'test', 'test', '13712345678', 1, 0);
INSERT INTO `users` VALUES (60, 'TEST', 'test@sjtu.edu.cn', 'test2', 'test', '13654651238', 1, 0);
INSERT INTO `users` VALUES (139, '', '1171153987@qq.com', 'test3', '123456', '13754151286', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
