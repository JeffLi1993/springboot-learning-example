# springboot-learning-example
spring boot 实践学习案例，是 spring boot 初学者及核心技术巩固的最佳实践。

## 作者与学习乐园
源码地址：我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者：[泥瓦匠BYSocket](http://www.bysocket.com/ "泥瓦匠BYSocket")<br>
QQ 群<br>
编程之美① 365234583  [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美") <br>
编程之美② 290714704  [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美")

## 项目结构
springboot 版本 1.5.1.RELEASE
- springboot-helloworld<br>
入门 HelloWorld 案例，Quick Start - [Spring Boot 之 HelloWorld详解](http://www.bysocket.com/?p=1124 "Spring Boot 之 HelloWorld详解")<br>
- springboot-mybatis<br>
Springboot 整合 Mybatis，数据库 MySQL
- springboot-restful-json<br>
Springboot 实现 Restful 服务，基于 HTTP / JSON 传输


## 项目 Quick Start
##### 基本环境配置
在 MySQL 中，创建数据库 bysocket：
````
CREATE DATABASE bysocket;
````
创建表
````
DROP TABLE IF EXISTS `account_bind`;
CREATE TABLE `account_bind` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `buyer_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '有赞帐号ID',
  `fans_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '粉丝ID',
  `fans_type` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '粉丝类型',
  `nobody` varchar(50) NOT NULL DEFAULT '' COMMENT '用户随机hash',
  `kdt_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '店铺ID',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `update_time` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fans_id_type` (`fans_id`,`fans_type`),
  KEY `buyer_id` (`buyer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='帐号绑定关系表';
````


##### 运行 springboot-mybatis 工程
