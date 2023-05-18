package com.vo.client;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年11月15日
 *
 */
@Configuration
@ConfigurationProperties(prefix = "conf")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AppConf {

	@NotNull(message = "appId 必须配置")
	private Integer appId;

	@NotEmpty(message = "confUrl 必须配置")
	private String confUrl;

	@NotEmpty(message = "appSecretKey 必须配置")
	private String appSecretKey;

	@NotEmpty(message = "appNmae 必须配置")
	private String appName;

}
