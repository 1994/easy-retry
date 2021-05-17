package com.alibaba.easyretry.core.process.async.on;

import com.alibaba.easyretry.common.AbstractResultPredicate;
import com.alibaba.easyretry.common.util.RetryUtils;
import com.alibaba.easyretry.core.context.MaxAttemptsPersistenceRetryContext;

/**
 * @author Created by wuhao on 2021/3/19.
 */
public class ResultAsynPersistenceOnRetryProcessor<R> extends
	AbstractAsyncPersistenceOnRetryProcessor<R> {

	private final R result;

	public ResultAsynPersistenceOnRetryProcessor(R result,
		MaxAttemptsPersistenceRetryContext context) {
		super(context);
		this.result = result;
	}

	@Override
	public boolean needRetry() {
		String resultPredicateSerializerStr = context.getAttribute("resultPredicateSerializer");
		if (RetryUtils.isEmpty(resultPredicateSerializerStr)) {
			return false;
		}
		AbstractResultPredicate resultPredicate = context.getResultPredicateSerializer()
			.deSerialize(resultPredicateSerializerStr);
		return (Boolean) resultPredicate.apply(result);
	}

	@Override
	public R getResult() {
		return result;
	}
}
