package cn.ictgu.mongo.model;

import java.util.Date;
import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * Created by Silence on 2017/4/22.
 */
@Data
@NoArgsConstructor
@ToString
public class User {

	// @Id
	// private String id;

	// 用户名
	// @Indexed(unique = true)
	private String username;

	// 密码
	private String password;

	// 昵称
	private String nickname;

	// 头像
	private String avatar;

	// 登录时间
	private Date joinTime;

	public User(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.avatar = "/image/avatar/avatar" + new Random().nextInt(10) + ".jpg";
		this.joinTime = new Date();
	}

}
