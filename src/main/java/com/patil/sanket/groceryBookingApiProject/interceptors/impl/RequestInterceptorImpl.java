package com.patil.sanket.groceryBookingApiProject.interceptors.impl;

import com.patil.sanket.groceryBookingApiProject.common.CommonMethods;
import com.patil.sanket.groceryBookingApiProject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.patil.sanket.groceryBookingApiProject.common.Constants.*;

@Component
public class RequestInterceptorImpl implements HandlerInterceptor {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userName = request.getHeader(USER_NAME);
        if(CommonMethods.isEmpty(userName)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User is Missing");
            return false;
        }
        String role = usersRepository.findByuName(userName).getuRole();
        String method = request.getMethod();
        System.out.println("preHandle Interceptor :: user : " + userName + ", role : " + role + ", method : " + method);
        StringBuilder sb = new StringBuilder();
        if (request.getRequestURI().contains("book")) {
            // user is allowed to book the items
            if(ROLE_USER.equalsIgnoreCase(role)) {
                return true;
            } else {
                sb.append(userName).append(" is not allowed to Book Items");
                System.out.println(sb.toString());
                response.sendError(HttpServletResponse.SC_FORBIDDEN, sb.toString());
                return false;
            }
        } else if (GET_OPERATION.equalsIgnoreCase(method)) {
            return true;
        } else if (ADMIN_ALLOWED_OPERATION_SET.contains(method) && ROLE_ADMIN.equalsIgnoreCase(role)) {
            return true;
        }
        sb.append(userName).append(" is not allowed to perform ").append(method).append(" operation");
        System.out.println(sb.toString());
        response.sendError(HttpServletResponse.SC_FORBIDDEN, sb.toString());
        return false;
    }
}
