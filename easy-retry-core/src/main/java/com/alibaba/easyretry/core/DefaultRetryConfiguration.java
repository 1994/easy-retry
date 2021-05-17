package com.alibaba.easyretry.core;

import com.alibaba.easyretry.common.RetryConfiguration;
import com.alibaba.easyretry.common.access.RetrySerializerAccess;
import com.alibaba.easyretry.common.access.RetryStrategyAccess;
import com.alibaba.easyretry.common.access.RetryTaskAccess;
import com.alibaba.easyretry.common.event.RetryEventMulticaster;
import com.alibaba.easyretry.common.resolve.ExecutorSolver;
import com.alibaba.easyretry.common.serializer.ResultPredicateSerializer;
import com.alibaba.easyretry.common.strategy.StopStrategy;
import com.alibaba.easyretry.common.strategy.WaitStrategy;
import com.alibaba.easyretry.core.access.DefaultRetrySerializerAccess;
import com.alibaba.easyretry.core.access.MemoryRetryTaskAccess;
import com.alibaba.easyretry.core.event.SimpleRetryEventMulticaster;
import com.alibaba.easyretry.core.strategy.DefaultRetryStrategy;

public class DefaultRetryConfiguration implements RetryConfiguration {

	@Override
	public RetryTaskAccess getRetryTaskAccess() {
		return new MemoryRetryTaskAccess();
	}

	@Override
	public RetrySerializerAccess getRetrySerializerAccess() {
		return new DefaultRetrySerializerAccess();
	}

	@Override
	public RetryStrategyAccess getRetryStrategyAccess() {
		return new RetryStrategyAccess() {
			@Override
			public StopStrategy getCurrentGlobalStopStrategy() {
				return new DefaultRetryStrategy();
			}

			@Override
			public WaitStrategy getCurrentGlobalWaitStrategy() {
				return new DefaultRetryStrategy();
			}
		};
	}

	@Override
	public ExecutorSolver getExecutorSolver() {
		return null;
	}

	@Override
	public ResultPredicateSerializer getResultPredicateSerializer() {
		return null;
	}

	@Override
	public Integer getMaxRetryTimes() {
		return 100;
	}

	@Override
	public RetryEventMulticaster getRetryEventMulticaster() {
		return new SimpleRetryEventMulticaster();
	}
}
