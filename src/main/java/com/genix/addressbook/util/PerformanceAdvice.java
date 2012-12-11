package com.genix.addressbook.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * need to paass vm arg
 * "-javaagent:/home/fazlan/Desktop/Vijitha/WORKSPACE/lib/spring-instrument-3.1.2.RELEASE.jar"
 * for run the LTW.
 * 
 * @author Vijitha
 * 
 */
@Aspect
public class PerformanceAdvice {

	@Around("methodsToBeProfiled()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch(getClass().getSimpleName());
		try {
			sw.start(pjp.getSignature().getName());
			return pjp.proceed();
		} finally {
			sw.stop();
			System.out.println("############## Performance : " + sw.prettyPrint());
		}
	}

	@Pointcut("execution(public * com.genix.addressbook.dao..*.*(..))")
	public void methodsToBeProfiled() {
		System.out.println("Method found like ....");
	}
}
