package com.submission.common.domain;

import lombok.*;

import java.util.List;

/**
 * 登录用户信息
 * Created by macro on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private List<String> permissionList;
}

