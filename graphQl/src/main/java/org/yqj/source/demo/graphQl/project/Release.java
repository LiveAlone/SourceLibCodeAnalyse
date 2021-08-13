package org.yqj.source.demo.graphQl.project;

import lombok.Data;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/13
 * Email: yaoqijunmail@foxmail.com
 */
@Data
public class Release {

	private String version;

	private ReleaseStatus status;

	private String referenceDocUrl;

	private String apiDocUrl;

	private boolean current;
}
