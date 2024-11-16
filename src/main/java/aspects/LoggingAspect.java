package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    long t1, t2;

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Pointcut("execution(* metier.*.*(..))")
    public void pc1() {}

     @Before("pc1()")
    public void logBefore(JoinPoint jp) {
        t1 = System.currentTimeMillis();
       logger.info("Log before " + jp.getSignature());
    }

    @After("pc1()")
    public void logAfter(JoinPoint jp) {
        logger.info("Log after " + jp.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("Duration = " + (t2 - t1) + " ms");
    }
}
