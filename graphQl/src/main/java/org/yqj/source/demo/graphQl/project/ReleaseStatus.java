package org.yqj.source.demo.graphQl.project;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/13
 * Email: yaoqijunmail@foxmail.com
 */
public enum ReleaseStatus {

	GENERAL_AVAILABILITY, MILESTONE, SNAPSHOT;

	@JsonCreator
	public static ReleaseStatus fromName(String name) {
		return Arrays.stream(ReleaseStatus.values())
				.filter(type -> type.name().equals(name))
				.findFirst()
				.orElse(ReleaseStatus.GENERAL_AVAILABILITY);
	}

}
