package com.vo.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import com.vo.core.ZLog2;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年11月15日
 *
 */
@Component
public class F implements EnvironmentPostProcessor {

	private final static ZLog2 LOG = ZLog2.getInstance();

	String appUrl = "/app";

	private static final int LENGTH = 2;

	@Override
	public void postProcessEnvironment(final ConfigurableEnvironment environment, final SpringApplication application) {

		LOG.info("conf_client启动");

		// FIXME 2022年11月15日 上午10:39:56 zhanghen: name待定
		final String name = "applicationConfig: [classpath:/application-re.properties]";
//		final String name = "applicationConfig: [classpath:/application.properties]";
		final MutablePropertySources propertySources = environment.getPropertySources();
		final MapPropertySource propertySourceA = (MapPropertySource) environment.getPropertySources().get(name);
		final Object confUrl = propertySourceA.getProperty("conf.conf-url");
		final Object appId = propertySourceA.getProperty("conf.app-id");
//		System.out.println("conf-confUrl = " + confUrl);
//		System.out.println("conf-appId = " + appId);

		LOG.info("conf_client开始从server拉取配置信息,serverConfURL={},clientAppId={}", confUrl, appId);

		final Map<String, Object> source = propertySourceA.getSource();

		final Map<String, Object> map = new HashMap<>();
		source.forEach((k, v) -> {
			map.put(k, String.valueOf(v).trim());
		});

		final long t11 = System.currentTimeMillis();
		final CR<AppResultDTO> cr = AppInfoService.getAppInfo(String.valueOf(confUrl), Integer.valueOf(String.valueOf(appId)));
		final long t22 = System.currentTimeMillis();

		LOG.info("conf_client从server拉取的配置信息耗时{}毫秒", (t22 - t11));
		LOG.info("conf_client从server拉取的配置信息={}", cr);

		final List<ConfResultDTO> confList = cr.getData().getConfList();

		LOG.info("conf_client从server拉取的配置信息.size={}", confList.size());

		LOG.info("conf_client开始查找需要更新的配置项");

		final long t1 = System.currentTimeMillis();

		map.forEach((k, v) -> {

			final String vs = String.valueOf(v);
			if ((Objects.nonNull(vs) && vs.length() > LENGTH) && (vs.startsWith("{") && vs.endsWith("}"))) {

				final String vk = vs.substring(1, vs.length() - 1);
				LOG.info("conf_client找到配置项-[{}]", k + "={" + vk + "}");

				final Optional<ConfResultDTO> findAny = confList.stream().filter(c -> c.getName().equals(vk)).findAny();
				if (findAny.isPresent()) {
					final String nvk = String.valueOf(findAny.get().getValue());
					map.put(k, nvk);
					LOG.info("conf_client更新值以后-[{}]", k + "=" + nvk);
				}
			}
		});

		final long t2 = System.currentTimeMillis();

		LOG.info("conf_client设置所有配置项完成，耗时{}毫秒", (t2 - t1));

//		// 将配置的端口号修改为 811222022
//		map.replace("server.port", 11222);
		environment.getPropertySources().replace(name, new MapPropertySource(name, map));
	}

	private void sendClientInfo() {

	}
}
