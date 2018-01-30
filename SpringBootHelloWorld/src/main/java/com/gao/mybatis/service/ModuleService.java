package com.gao.mybatis.service;


import com.gao.mybatis.domain.ModuleInfo;

import java.util.List;

public interface ModuleService {
	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	List<ModuleInfo> findModuleByUserId(int userId);
}
