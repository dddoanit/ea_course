/**
* Author: DatDoan
* Created Date: Apr 10, 2018
*/
package cs544.spring.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import cs544.spring.bank.logging.ILogger;

@Aspect
public class DaoLogging {
  public ILogger logger;
  @After("execution(* cs544.spring.bank.dao.*.*(..))")
  public void log(JoinPoint joinPoint) {
    logger.log("Called method " + joinPoint.getSignature().getName() + " from class " + joinPoint.getSignature().getDeclaringTypeName());
    logger.log("DAO log: " + joinPoint.toLongString());
  }
  
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
}
