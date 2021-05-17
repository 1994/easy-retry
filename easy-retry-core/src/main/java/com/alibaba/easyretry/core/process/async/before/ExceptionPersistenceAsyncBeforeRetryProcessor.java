package com.alibaba.easyretry.core.process.async.before;

import com.alibaba.easyretry.common.retryer.RetryerInfo;
import java.util.Objects;

/**
 * @author Created by wuhao on 2021/3/19.
 */
public class ExceptionPersistenceAsyncBeforeRetryProcessor<R> extends
	AbstractAsyncPersistenceBeforeRetryProcessor<R> {

	private final Throwable throwable;

	public ExceptionPersistenceAsyncBeforeRetryProcessor(Throwable throwable,
		RetryerInfo<R> retryerInfo) {
		super(retryerInfo);
		this.throwable = throwable;
	}

	@Override
	public boolean needRetry() {
		Class<? extends Throwable> onException = retryerInfo.getOnException();
		if (Objects.isNull(onException)) {
			return true;
		}
//		fixme need test
		return throwable.getClass().isAssignableFrom(retryerInfo.getOnException());
//		return ClassUtils.isAssignable(retryerInfo.getOnException(), throwable.getClass());
	}

	@Override
	public R getResult() throws Throwable {
		if (retryerInfo.isReThrowException()) {
			throw throwable;
		} else {
			return null;
		}
	}
}
