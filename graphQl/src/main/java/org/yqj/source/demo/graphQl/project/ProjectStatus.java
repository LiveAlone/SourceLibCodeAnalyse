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
public enum ProjectStatus {

	ACTIVE, COMMUNITY, INCUBATING, ATTIC;

	@JsonCreator
	public static ProjectStatus fromName(String name) {
		return Arrays.stream(ProjectStatus.values())
				.filter(type -> type.name().equals(name))
				.findFirst()
				.orElse(ProjectStatus.ACTIVE);
	}

}
