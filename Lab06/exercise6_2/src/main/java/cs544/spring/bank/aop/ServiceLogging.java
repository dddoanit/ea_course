/**
* Author: DatDoan
* Created Date: Apr 10, 2018
*/
package cs544.spring.bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;
import cs544.spring.bank.logging.ILogger;

@Aspect
public class ServiceLogging {
  private ILogger logger;
  @Around("execution(* cs544.spring.bank.service.*.*(..))")
  public Object logging(ProceedingJoinPoint call ) throws Throwable {
    StopWatch sw = new StopWatch();
    sw.start(call.getSignature().getName());
    Object retVal = call.proceed();
    sw.stop();
    long totaltime = sw.getLastTaskTimeMillis();
    // print the time to the console
    logger.log("Service Log: " + call.getSignature().getName() + " Time to execute save = "
        + totaltime + "ms");
    return retVal;
  }
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
  
}
