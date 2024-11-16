package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* test.Application.start(..))")
    public void startAppCut() {}

    @Around("startAppCut()")
    public void aroundStartApp(ProceedingJoinPoint pjp) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        if (!username.equals("admin") || !password.equals("admin")) {
            System.out.println("Access denied");
            System.exit(0);
        }
        pjp.proceed();
    }
}
