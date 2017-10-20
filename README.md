# belling-spring-rabbit

# 百灵Spring集成Rabbit封装

## 简介

Spring项目集成了消息队列-RabbitMQ，考虑到数据安全和稳定性，选择了RabbitMQ.当前开发环境在Win10下测试

## 内置功能

1.  基于普通消息订阅-发布模式的消息队列实现。
2.	基于延迟消息队列的实现。
3.	基于定时消息发送的功能实现。


## 使用场景

1.  订单信息实时和延迟推送到微信端。
2.  未支付的订单30分钟失效（之前是轮询，时间会存在偏差）

## 技术选型

1、后端

* 核心框架：Spring Framework 4.3.8
* 消息队列框架：spring-rabbit 1.6.1.RELEASE
* 日志管理：Log4j
* 工具类：Apache Commons、Guava

2、安装工具

* otp_win64_20.1.exe
* rabbitmq-server-3.6.12.exe
* rabbitmq_delayed_message_exchange-0.0.1.ez （延时消息插件-必备）

## 注意事项

1.  RabbitMQ本身是不支持延迟消息发送，需要下载rabbitmq_delayed_message_exchange-0.0.1.ez插件，并执行安装，否则延迟消息将失效。



