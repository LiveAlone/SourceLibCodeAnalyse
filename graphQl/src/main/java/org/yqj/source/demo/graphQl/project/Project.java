package org.yqj.source.demo.graphQl.project;

import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/13
 * Email: yaoqijunmail@foxmail.com
 */
@Data
public class Project {

	private String slug;

	private String name;

	private String repositoryUrl;

	private ProjectStatus status;

	private List<Release> releases;
}
