-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `passwordencrypt` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `telphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `weixin` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '1代表男  2代表女',
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
-- ----------------------------
-- Records of user
-- ----------------------------

CREATE TABLE `mechant` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `merchantname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `merchantshopname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `merchantaccount` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mechantpassword` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mechantscope` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `auditstatus` int(2) DEFAULT NULL COMMENT '1. 提交成功 2. 审核通过 3，审核不通过',
	`soldout` int(2) DEFAULT NULL COMMENT '1. 正常 2. 下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `ordermain` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `payamount` int(20) DEFAULT NULL COMMENT '支付金融',
  `userid` int(20) DEFAULT NULL COMMENT '用户id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `paytime` datetime DEFAULT NULL COMMENT '支付时间',
  `paystatus` int(2) DEFAULT NULL COMMENT '支付状态 1 未支付 2 已支付 3 退款',
  `consigneeadress` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人地址',
  `consigneephone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人电话',
  `consigneename` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人姓名',
  `tradenumber` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '交易流水号',
  `paytype` int(2) DEFAULT NULL COMMENT '支付类型',
  `orderstatus` int(2) DEFAULT NULL COMMENT '订单状态 0 正常 1 是取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `orderdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `orderid` int(20) DEFAULT NULL,
  `productid` int(20) DEFAULT NULL COMMENT '商品id',
  `mechartid` int(20) DEFAULT NULL COMMENT '商家id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `tradenum` int(20) DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `product` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `producttypeid` int(20) DEFAULT NULL COMMENT '商品类别id',
  `producttitle` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品标题',
  `productprice` int(20) DEFAULT NULL COMMENT '商品价格',
  `mechartid` int(20) DEFAULT NULL COMMENT '商家id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `audittime` datetime DEFAULT NULL COMMENT '审核时间',
  `auditstate` int(2) DEFAULT NULL COMMENT '审核状态',
  `stocknum` int(20) DEFAULT NULL COMMENT '库存',
  `sellnum` int(20) DEFAULT NULL COMMENT '销售数量',
  `productpicurl` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片地址',
  `productstatus` int(2) DEFAULT NULL COMMENT '商品上下架 0 代表正常上架 1代表下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `productdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `proudctid` int(20) DEFAULT NULL COMMENT '商品id',
  `productplace` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品产地',
  `productdescription` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品详情描述',
  `productbrand` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品品牌',
  `productweight` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品重量',
  `productspecification` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '商品规格说明和包装',
  `productdetaipicurl` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '商品详情图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producttypename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `producttypedescription` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `typegrade` int(11) DEFAULT NULL COMMENT '等级 1,2,3 1等级最大',
  `parentid` int(11) DEFAULT NULL COMMENT '父等级id 第一等级的话 父等级为空',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
----
测试git是否成功
https://baijiahao.baidu.com/s?id=1619544681032320225&wfr=spider&for=pc
git push -u origin master