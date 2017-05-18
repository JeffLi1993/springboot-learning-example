package cn.ictgu.chat.Model;

import java.util.Date;

import lombok.Data;

/**
 * 基本消息类型 Created by Silence on 2017/4/21.
 */
@Data
public class BaseMessage {

	// 消息ID
	// @Id
	// private String id;

	// 消息类型
	private String type;

	// 消息内容
	private String content;

	// 发送者
	private String sender;

	// 接受者 类型
	private String toType;

	// 接受者
	private String receiver;

	// 发送时间
	private Date date;

}
