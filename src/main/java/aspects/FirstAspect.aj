package aspects;

import com.sun.prism.impl.shape.BasicRoundRectRep;

public aspect FirstAspect {
    pointcut pc1() : execution(* test.Application.main(..));

//    before() : pc1() {
//        System.out.println("FirstAspect: before main");
//    }
//
//    after() : pc1() {
//        System.out.println("FirstAspect: after main");
//    }

    void  around()  : pc1() {
        System.out.println("FirstAspect: around main");
        proceed();
        System.out.println("FirstAspect: around main");
    }
}
