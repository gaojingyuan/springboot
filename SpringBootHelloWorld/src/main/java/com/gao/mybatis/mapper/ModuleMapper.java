package com.gao.mybatis.mapper;

import com.gao.mybatis.domain.ModuleInfo;
import com.gao.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;



public interface ModuleMapper extends MyMapper<ModuleInfo> {

	/**
	 * 获取该人的权限模块
	 * @param userId
	 * @return
	 */
	@Select(value="select e.* from t_user_role b left join t_role c on b.role_id=c.id left join t_role_module d on c.id=d.role_id left join t_module e on d.module_id=e.id where b.user_id=#{userId}")
	List<ModuleInfo> findModuleByUserId(int userId);
}
