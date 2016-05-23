package com.Jms.Interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Intercept {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception
	{
		System.out.println("Interceptors Test"+ctx.getMethod().getName());
		return ctx.proceed();
		
	}
}
