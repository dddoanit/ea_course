/**
 * Author: DatDoan Created Date: Apr 10, 2018
 */
package cs544.exercise6_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class CustomerDaoAdvice {
  @Around("execution(* cs544.exercise6_1.CustomerDAO.*(..))")
  public Object invoke(ProceedingJoinPoint call) throws Throwable {
    StopWatch sw = new StopWatch();
    sw.start(call.getSignature().getName());
    Object retVal = call.proceed();
    sw.stop();
    long totaltime = sw.getLastTaskTimeMillis();
    // print the time to the console
    System.out.println("Time to execute save = " + totaltime + "ms");
    return retVal;
  }
}
