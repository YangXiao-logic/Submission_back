package com.submission.gateway.component;

import cn.dev33.satoken.stp.StpInterface;

import java.util.List;

/**
 * @author YangXiao
 * @since 2022/10/3 15:31
 */
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
