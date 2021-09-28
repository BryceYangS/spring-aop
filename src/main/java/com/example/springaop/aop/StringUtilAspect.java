package com.example.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class StringUtilAspect {
	public static final Logger log = LoggerFactory.getLogger(StringUtilAspect.class);

	@Before("execution(* com.example.springaop.stringutil.StringUtilService.*(..))")
	public void logMethodExcutionStart() {
		log.info("Method execution started");
	}

	@AfterReturning("execution(* com.example.springaop.stringutil.StringUtilService.capitalizeAllLetters(..))")
	public void logSuccessCapitalizeAllLetters() {
		log.info("Finished successfully");
	}

	@Around("execution(* com.example.springaop.stringutil.StringUtilService.removeAllWhitespaces(..))")
	public void logDurationRemoveAllWhitespaces(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();

		Object proceed = joinPoint.proceed();
		sw.stop();
		log.info("Duration in milliseconds: " + sw.getTotalTimeMillis());
	}

	@AfterReturning("execution(* com.example.springaop.stringutil.StringUtilService.removeAllNumbers(..))")
	public void logRemovedAllNumbers() {
		log.info("Removed all numbers");
	}

	@AfterThrowing(
		pointcut = "execution(* com.example.springaop.stringutil.StringUtilService.removeAllNumbers(..))",
		throwing = "ex")
	public void logErrorRemovedAllNumbers(IllegalStateException ex) {

		log.error("Error state");

	}
}
