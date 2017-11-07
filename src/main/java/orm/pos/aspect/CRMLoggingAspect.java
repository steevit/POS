package orm.pos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//utwórz loger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//ustaw deklaracje pointcuta
	@Pointcut("execution(* sbd.pos.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* sbd.pos.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* sbd.pos.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//wyœwietl wywo³ywan¹ metodê
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @Before: calling method: " + theMethod);
		
		//wyœwietl argumenty metody
		
		//pobierz argumenty
		Object[] args = theJoinPoint.getArgs();
		
		//wyœwietl argumenty
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
		
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning: from method: " + theMethod);
		
		myLogger.info("=====>> result: " + theResult);
		
	}
	
}
