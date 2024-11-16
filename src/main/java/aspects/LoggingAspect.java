package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {


    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Pointcut("execution(* metier.*.*(..))")
    public void pc1() {}

//     @Before("pc1()")
//    public void logBefore(JoinPoint jp) {
//        t1 = System.currentTimeMillis();
//       logger.info("Log before " + jp.getSignature());
//    }
//
//    @After("pc1()")
//    public void logAfter(JoinPoint jp) {
//        logger.info("Log after " + jp.getSignature());
//        t2 = System.currentTimeMillis();
//        logger.info("Duration = " + (t2 - t1) + " ms");
//    }

    @Around("pc1()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("Log before " + pjp.getSignature());
        try {
           Object object =  pjp.proceed();
           return object;
        } finally {
            long t2 = System.currentTimeMillis();
            logger.info("Log after " + pjp.getSignature());
            logger.info("Duration = " + (t2 - t1) + " ms");
        }
    }

}
