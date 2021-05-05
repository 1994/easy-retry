package com.alibaba.easyretry.core.event;

import com.alibaba.easyretry.common.event.RetryEvent;
import com.alibaba.easyretry.common.event.RetryEventMulticaster;
import com.alibaba.easyretry.common.event.RetryListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by wuhao on 2021/3/26.
 */
public class SimpleRetryEventMulticaster implements RetryEventMulticaster {

	private static final List<RetryListener> listenerCaches = new ArrayList<>(16);

	@Override
	public void register(RetryListener listener) {
		listenerCaches.add(listener);
	}

	@Override
	public void multicast(RetryEvent retryEvent) {
		listenerCaches.forEach((retryListener) -> retryListener.onRetryEvent(retryEvent));
	}
}
