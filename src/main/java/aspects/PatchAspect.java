package aspects;

import metier.IMetierImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchAspect {

    @Pointcut("execution(* metier.*.withdraw(..))")
    public void pc1() {}

    @Around("pc1()")
    public Object aroundWithdraw(ProceedingJoinPoint pjp, JoinPoint joinPoint) throws Throwable {
        IMetierImpl metier = (IMetierImpl) joinPoint.getTarget();
        Long code = (Long) pjp.getArgs()[0];
        double amount = (double) pjp.getArgs()[1];
        double solde = metier.getCompte(code).getSolde();
        if (solde - amount < 0) {
            throw new RuntimeException("Solde insuffisant");
        }
        return pjp.proceed();
    }

}
