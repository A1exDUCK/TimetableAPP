package rut.miit.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingModule {

    private static final Logger logger = LoggerFactory.getLogger(LoggingModule.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || within(rut.miit.web..*)")
    public void controller() {}

    @Around("controller()")
    public Object logRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("Request: [method={}, URI={}, params={}]",
                request.getMethod(),
                request.getRequestURI(),
                request.getParameterMap());

        Object result = joinPoint.proceed();
        logger.info("Response: [status={}, body={}]",
                HttpServletResponse.SC_OK,
                result);

        return result;
    }
}