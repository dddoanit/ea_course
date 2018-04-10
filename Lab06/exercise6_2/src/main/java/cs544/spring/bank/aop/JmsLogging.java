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
public class JmsLogging {
  private ILogger logger;
  @After("execution(* cs544.spring.bank.jms.JMSSender.sendJMSMessage(String)) && args(text)")
  public void logging(JoinPoint joinPoint, String text) {
    logger.log("JMS log: sent " + text);
  }
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }
}
