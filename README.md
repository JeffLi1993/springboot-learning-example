# springboot-learning-example
spring boot 实践学习案例，是 spring boot 初学者及核心技术巩固的最佳实践。

## 作者与学习乐园
源码地址：我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者：[泥瓦匠BYSocket](http://www.bysocket.com/ "泥瓦匠BYSocket")<br>
QQ 群<br>
编程之美① 365234583  [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美") <br>
编程之美② 290714704  <br><br>
关注微信公众号【泥瓦匠BYSokcet】，及时得到技术文章推送<br>
![公众号](https://github.com/JeffLi1993/springboot-learning-example/blob/master/doc/qrcode.jpg)


## 一、项目结构
「Spring Boot 那些事」：[传送门](http://www.bysocket.com/?page_id=1639 "Spring Boot 那些事")<br>

##### a. 基础
springboot 版本 1.5.1.RELEASE
- springboot-helloworld<br>
入门 HelloWorld 案例，Quick Start <br>
 [《Spring Boot 之 HelloWorld 详解》](http://www.bysocket.com/?p=1124 "Spring Boot 之 HelloWorld详解")<br>

##### b. Web 开发相关
- springboot-mybatis <br>
 [《Springboot 整合 Mybatis 的完整 Web 案例》](http://www.bysocket.com/?p=1610 "Springboot 整合 Mybatis 的完整 Web 案例")<br>
- springboot-mybatis-mutil-datasource <br>
 [《Spring Boot 整合 Mybatis 实现 Druid 多数据源详解》](http://www.bysocket.com/?p=1712 "Spring Boot 整合 Mybatis 实现 Druid 多数据源详解")<br>
- springboot-restful <br>
 [《Springboot 实现 Restful 服务，基于 HTTP / JSON 传输》](http://www.bysocket.com/?p=1627 "Springboot 实现 Restful 服务，基于 HTTP / JSON 传输")<br>
- springboot-restful <br>
 [《Spring Boot 集成 FreeMarker 详解案例》](http://www.bysocket.com/?p=1666 "Spring Boot 集成 FreeMarker 详解案例")<br>
- springboot-dubbo-server <br>
- springboot-dubbo-client <br>
Dubbo 服务提供者工程和 Dubbo 服务消费者工程 <br>
 [《Springboot 整合 Dubbo/ZooKeeper 详解 SOA 案例》](http://www.bysocket.com/?p=1681 "Springboot 整合 Dubbo/ZooKeeper 详解 SOA 案例")<br>
- springboot-validation-over-json <br>
 [《Spring Boot HTTP over JSON 的错误码异常处理》](http://www.bysocket.com/?p=1692 "Spring Boot HTTP over JSON 的错误码异常处理")<br>
- springboot-mybatis-redis <br>
 [《Spring Boot 整合 Redis 实现缓存操作》](http://www.bysocket.com/?p=1712 "Spring Boot 整合 Mybatis 实现 Druid 多数据源详解")<br>


## 二、项目 Quick Start 快速开发指南
#### a. 基本环境配置
在 MySQL 中，创建数据库 springbootdb：
````
CREATE DATABASE springbootdb;
````
创建表 city 城市 (因为我喜欢徒步)
````
DROP TABLE IF EXISTS  `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
````
插入基础数据
````
INSERT city VALUES (1 ,1,'温岭市','BYSocket 的家在温岭。');
````
 <br>
### 《 springboot-mybatis 工程 Quick Start 》
首先 check 基本环境配置完成，创建好数据库和表。

#### 1. 修改数据库配置
配置文件地址：springboot-mybatis/src/main/resources/application.properties
修改相应的数据源配置，比如账号、密码等

#### 2. 编译工程
在项目根目录 `springboot-learning-example`，运行 maven 指令：
````
mvn clean install
````
#### 3. 运行工程
右键运行工程包中 `org.spring.springboot.Application` Spring Boot 应用启动类的 main 函数，然后在浏览器访问：
`````
http://localhost:8080/api/city?cityName=温岭市
`````
可以看到返回的 JSON 结果：
````
{
    "id": 1,
    "provinceId": 1,
    "cityName": "温岭市",
    "description": "我的家在温岭。"
}
````
