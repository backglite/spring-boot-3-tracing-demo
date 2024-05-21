package xyz.ruhshan.tracingspringboot3.restapi.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class TenantIdInterceptor implements HandlerInterceptor {

    public static final String TENANT_ID = "tenantId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader("Tenant-ID");
        MDC.put(TENANT_ID, tenantId);
        return true;
    }
}
