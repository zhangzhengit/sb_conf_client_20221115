package com.vo.client.test;

import java.util.List;

import javax.validation.constraints.NotEmpty;

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
 * @date 2022年12月5日
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@Validated
@ConfigurationProperties(prefix = "conf")
public class IdConf {

	@NotEmpty(message = "id不能配置为空")
	List<Integer> id;
}
