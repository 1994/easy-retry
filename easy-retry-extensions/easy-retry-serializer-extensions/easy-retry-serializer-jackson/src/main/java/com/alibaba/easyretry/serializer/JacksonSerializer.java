package com.alibaba.easyretry.serializer;

import com.alibaba.easyretry.common.serializer.ArgSerializerInfo;
import com.alibaba.easyretry.common.serializer.RetryArgSerializer;
import com.alibaba.easyretry.serializer.JacksonUtils;

public class JacksonSerializer implements RetryArgSerializer {

	@Override
	public String serialize(ArgSerializerInfo serializeInfo) {
		return JacksonUtils.INSTANCE.serialize(serializeInfo);
	}

	@Override
	public ArgSerializerInfo deSerialize(String infoStr) {
//		return JacksonUtils.INSTANCE.deserialize(infoStr, ArgSerializerInfo.class);
		return null;
	}
}
