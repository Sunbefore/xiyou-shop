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
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '1������  2����Ů',
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
  `auditstatus` int(2) DEFAULT NULL COMMENT '1. �ύ�ɹ� 2. ���ͨ�� 3����˲�ͨ��',
	`soldout` int(2) DEFAULT NULL COMMENT '1. ���� 2. �¼�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `ordermain` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `payamount` int(20) DEFAULT NULL COMMENT '֧������',
  `userid` int(20) DEFAULT NULL COMMENT '�û�id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  `paytime` datetime DEFAULT NULL COMMENT '֧��ʱ��',
  `paystatus` int(2) DEFAULT NULL COMMENT '֧��״̬ 1 δ֧�� 2 ��֧�� 3 �˿�',
  `consigneeadress` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '�ջ��˵�ַ',
  `consigneephone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '�ջ��˵绰',
  `consigneename` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '�ջ�������',
  `tradenumber` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '������ˮ��',
  `paytype` int(2) DEFAULT NULL COMMENT '֧������',
  `orderstatus` int(2) DEFAULT NULL COMMENT '����״̬ 0 ���� 1 ��ȡ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `orderdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `orderid` int(20) DEFAULT NULL,
  `productid` int(20) DEFAULT NULL COMMENT '��Ʒid',
  `mechartid` int(20) DEFAULT NULL COMMENT '�̼�id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  `tradenum` int(20) DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `product` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '����',
  `producttypeid` int(20) DEFAULT NULL COMMENT '��Ʒ���id',
  `producttitle` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ����',
  `productprice` int(20) DEFAULT NULL COMMENT '��Ʒ�۸�',
  `mechartid` int(20) DEFAULT NULL COMMENT '�̼�id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  `audittime` datetime DEFAULT NULL COMMENT '���ʱ��',
  `auditstate` int(2) DEFAULT NULL COMMENT '���״̬',
  `stocknum` int(20) DEFAULT NULL COMMENT '���',
  `sellnum` int(20) DEFAULT NULL COMMENT '��������',
  `productpicurl` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '��ƷͼƬ��ַ',
  `productstatus` int(2) DEFAULT NULL COMMENT '��Ʒ���¼� 0 ���������ϼ� 1�����¼�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `productdetail` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '����',
  `proudctid` int(20) DEFAULT NULL COMMENT '��Ʒid',
  `productplace` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ����',
  `productitle` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ����',
  `productbrand` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '��ƷƷ��',
  `productweight` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ����',
  `productspecification` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ���˵���Ͱ�װ',
  `productdetaipicurl` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '��Ʒ����ͼƬ��ַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producttypename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `producttypedescription` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `typegrade` int(11) DEFAULT NULL COMMENT '�ȼ� 1,2,3 1�ȼ����',
  `parentid` int(11) DEFAULT NULL COMMENT '���ȼ�id ��һ�ȼ��Ļ� ���ȼ�Ϊ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
