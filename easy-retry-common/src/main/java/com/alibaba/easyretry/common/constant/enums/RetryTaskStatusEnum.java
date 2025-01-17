package com.alibaba.easyretry.common.constant.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;

/**
 * 重试任务状态
 *
 * @author Created by wuhao on 2020/10/31.
 */
public enum RetryTaskStatusEnum {

	/**
	 * 初始化状态
	 */
	INIT(0, "初始化"),

	/**
	 * 任务处理中
	 */
	HANDLING(1, "处理中"),

	/**
	 * 任务处理异常
	 */
	ERROR(2, "异常"),

	/**
	 * 任务完结
	 */
	FINISH(3, "完结");

	private static final Map<Integer, RetryTaskStatusEnum> MAP =
		Stream.of(values())
			.collect(Collectors.toMap(RetryTaskStatusEnum::getCode, value -> value));
	@Getter
	private final int code;
	@Getter
	private final String desc;

	RetryTaskStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static RetryTaskStatusEnum fromCode(int code) {
		return MAP.get(code);
	}
}
