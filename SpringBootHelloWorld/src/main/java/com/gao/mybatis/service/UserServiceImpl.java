package com.gao.mybatis.service;

import com.gao.mybatis.domain.ModuleInfo;
import com.gao.mybatis.domain.UserInfo;
import com.gao.mybatis.mapper.UserMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ModuleService moduleService;

    @Bean
    public Converter<String, UserInfo> messageConverter() {
        return new Converter<String, UserInfo>() {
            @Override
            public UserInfo convert(String id) {
                return userMapper.selectByPrimaryKey(Integer.valueOf(id));
            }
        };
    }

    public UserInfo getById(Integer id) {
        return userMapper.getById(id);
    }

    /**
     * 根据账号Account查询当前用户
     * 
     * @param account
     * @return
     */

    public UserInfo findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    /**
     * 获取资源集合
     * 
     * @param account
     * @return
     */
    public Set<String> findPermissions(String account) {
        Set<String> set = Sets.newHashSet();
        UserInfo user = findByAccount(account);
        List<ModuleInfo> modules = moduleService.findModuleByUserId(user.getId());

        for (ModuleInfo info : modules) {
            set.add(info.getModuleKey());
        }
        return set;
    }

    /**
     * 获取URL权限
     * 
     * @param account
     * @return
     */
    public List<String> findPermissionUrl(String account) {
        List<String> list = Lists.newArrayList();
        UserInfo user = findByAccount(account);
        List<ModuleInfo> modules = moduleService.findModuleByUserId(user.getId());

        for (ModuleInfo info : modules) {
            if (info.getModuleType() == ModuleInfo.URL_TYPE) {
                list.add(info.getModulePath());
            }
        }
        return list;
    }

    public List<UserInfo> getUserList() {
        return userMapper.getUserList();
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public int saveUser(UserInfo user) {
        UserInfo uExist = userMapper.selectByPrimaryKey(user.getId());
        if (uExist == null) {
            userMapper.insertUseGeneratedKeys(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
        return user.getId();
    }
}