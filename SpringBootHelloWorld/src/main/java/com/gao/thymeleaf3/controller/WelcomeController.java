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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rob Winch
 * @author Doo-Hwan Kwak
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping(value = "welcome")
	public ModelAndView welcome() {
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("aaa");
		return new ModelAndView("welcome", "user", user);
	}

}
