package cn.ictgu.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ictgu.config.sercurity.UserPrincipal;
import cn.ictgu.mongo.model.User;
import cn.ictgu.mongo.service.RelationService;
import cn.ictgu.mongo.service.UserService;

/**
 * 通用 API Created by Silence on 2017/4/22.
 */
@RestController
@RequestMapping("/api/common")
public class CommonAPI {

	@Autowired
	private UserService userService;

	@Autowired
	private RelationService relationService;

	@PostMapping(value = "/register")
	public boolean register(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		User user = new User(username, password, nickname);
		// TODO 参数校验
		return userService.addUser(user);
	}

	@PostMapping("/add")
	public boolean add(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestParam String friend) {
		return relationService.addFriend(userPrincipal.getUsername(), friend);
	}

}
