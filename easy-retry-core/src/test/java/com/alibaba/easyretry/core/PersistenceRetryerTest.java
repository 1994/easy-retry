package com.alibaba.easyretry.core;

import com.alibaba.easyretry.common.SCallable;
import com.alibaba.easyretry.common.retryer.RetryerInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersistenceRetryerTest {

	@Test
	void retry() throws Throwable {
		Object call = new PersistenceRetryer<>(new RetryerInfo<>()
			.setArgs(new Object[]{"hello"})
			.setRetryConfiguration(new DefaultRetryConfiguration())
			.setExecutorMethodName("throwException"))
			.call(((SCallable<Object>) () -> PersistenceRetryerTest.throwException("hello")));
		Assertions.assertNotNull(call);
	}

	public static Object throwException(String message) {
		throw new UnsupportedOperationException(message);
	}
}
