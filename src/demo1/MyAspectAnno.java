package demo1;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {
    /**
     * 切面类 注解类型
     * @author XW
     *
     **/
    @Before (value = "execution(* demo1.OrderDao.save(..))")
    public void before(){
        System.out.println ("前置");
    }
    @AfterReturning(value = "execution(* demo1.OrderDao.delete(..))",returning = "result")
    public void after(Object result){
        System.out.println ("后置"+"--"+result);
    }
    @Around (value = "execution(* demo1.OrderDao.update(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println ("环绕前增强");
        Object obj = joinPoint.proceed ();
        System.out.println ("环绕后增强");
        return obj;
    }
    @AfterThrowing(value = "execution(* demo1.OrderDao.find(..))",throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println ("异常抛出增强");
    }
    @After (value = "MyAspectAnno.pointcut1()")
    public void after(){
        System.out.println ("最终通知增强");
    }

    @Pointcut(value = "execution(* demo1.OrderDao.find(..))")
    private void pointcut1(){}
}
