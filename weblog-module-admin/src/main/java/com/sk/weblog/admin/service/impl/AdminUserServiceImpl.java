package com.sk.weblog.admin.service.impl;

import com.sk.weblog.admin.model.vo.user.FindUserInfoRspVO;
import com.sk.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.sk.weblog.admin.service.AdminUserService;
import com.sk.weblog.common.domain.mapper.UserMapper;
import com.sk.weblog.common.enums.ResponseCodeEnum;
import com.sk.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        String encode = passwordEncoder.encode(updateAdminUserPasswordReqVO.getPassword());
        int count = userMapper.updatePasswordByUsername(updateAdminUserPasswordReqVO.getUsername(), encode);
        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    @Override
    public Response findUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        FindUserInfoRspVO vo = new FindUserInfoRspVO();
        vo.setUsername(username);
        return Response.success(vo);
    }
}
