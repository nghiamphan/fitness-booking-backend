package smu.mcda5540.fitnessbooking.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
    private final Environment environment;

    @Autowired
    public LoggingAspect(Environment environment) {
        this.environment = environment;
    }

    @AfterThrowing(pointcut = "execution(* smu.mcda5540.fitnessbooking.*.*Impl.*(..))", throwing = "e")
    public void afterThrowing(Exception e) {
        if (e instanceof FitnessBookingException) {
            LOGGER.error(environment.getProperty(e.getMessage()));
        } else {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterReturning(pointcut = "execution(* smu.mcda5540.fitnessbooking.controller.*.*(..))", returning = "response")
    public void logResponse(Object response) {
        LOGGER.info("RESPONSE: " + response);
    }
}