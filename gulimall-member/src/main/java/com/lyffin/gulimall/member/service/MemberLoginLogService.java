package com.lyffin.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.common.utils.PageUtils;
import com.lyffin.gulimall.member.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 20:01:45
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

