package io.github.lyk98.fast.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import io.github.lyk98.fast.common.constant.Constants;
import io.github.lyk98.fast.common.core.domain.AjaxResult;
import io.github.lyk98.fast.common.core.domain.model.LoginUser;
import io.github.lyk98.fast.common.utils.ServletUtils;
import io.github.lyk98.fast.common.utils.StringUtils;
import io.github.lyk98.fast.framework.manager.AsyncManager;
import io.github.lyk98.fast.framework.manager.factory.AsyncFactory;
import io.github.lyk98.fast.framework.web.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 *
 * @author ruoyi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success("退出成功")));
    }
}
