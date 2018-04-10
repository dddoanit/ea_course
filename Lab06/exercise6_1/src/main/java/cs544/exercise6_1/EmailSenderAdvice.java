/**
* Author: DatDoan
* Created Date: Apr 10, 2018
*/
package cs544.exercise6_1;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmailSenderAdvice {
  @After("execution(* cs544.exercise6_1.EmailSender.sendEmail(..)) && args(email, message)")
  public void traceAfterSendEmail(JoinPoint joinPoint, String email, String message) {
    System.out.println(new Date() + " method= sendMail address=" + email + " mesasge=" + message);
    EmailSender emailSender = (EmailSender)joinPoint.getTarget();
    System.out.println("outgoing mail server = " + emailSender.getOutgoingMailServer());
  }
}
