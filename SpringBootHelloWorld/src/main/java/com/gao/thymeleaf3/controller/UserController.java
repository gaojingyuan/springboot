/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gao.thymeleaf3.controller;

import com.gao.mybatis.domain.UserInfo;
import com.gao.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Rob Winch
 * @author Doo-Hwan Kwak
 */
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView list() {
		List<UserInfo> users = userService.getUserList();
		return new ModelAndView("users/list", "users", users);
	}

// 1.用@PathVariable("id")参数 需在UserService中配置Converter 查看和修改统一在Converter中 如果没配置convertor 只能得到Id
	// 2.用@ModelAttribute("user")参数 查看、修改、编辑功能会从getUserInfo方法获取对象

	// @GetMapping("{id}")
	// public ModelAndView view(@PathVariable("id") Integer id) {
	// User user = userService.getUserById(id);
	// return new ModelAndView("users/view", "user", user);
	// }
	@GetMapping("{id}")
	public ModelAndView view(/*@PathVariable("id") */@ModelAttribute("user") UserInfo user) {
		return new ModelAndView("users/view", "user", user);
	}

	// @GetMapping(params = "form")
	// public String saveForm(@ModelAttribute UserInfo user) {
	// return "users/form";
	// }
	@GetMapping(params = "form")
	public ModelAndView saveForm(/*@ModelAttribute */UserInfo user) {
		return new ModelAndView("users/form", "user", user);
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(/*@PathVariable("id") */@ModelAttribute("user") UserInfo user) {
		return new ModelAndView("users/form", "user", user);
	}

	@ModelAttribute("user")
	public UserInfo getUserInfo(UserInfo user) {
		if (null == user.getId()) {
			return null;
		}
		return userService.getById(user.getId());
	}

	@PostMapping
	public ModelAndView save(@Valid @ModelAttribute("user") UserInfo user, BindingResult result,
							 RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("users/form", "formErrors", result.getAllErrors());
		}
		int userId = userService.saveUser(user);
		redirect.addFlashAttribute("globalMessage", "Successfully");
		return new ModelAndView("redirect:/users/{user.id}", "user.id", userId);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		userService.deleteById(id);
		List<UserInfo> users = userService.getUserList();
		return new ModelAndView("users/list", "users", users);
	}


}
