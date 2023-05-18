package com.vo.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.hutool.http.HttpUtil;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年11月15日
 *
 */
public class AppInfoService {

	public static CR<AppResultDTO> getAppInfo(final String url, final Integer appId) {

		final String urlA = url + "/" + AppEnum.GET_APP_INFO.getUrl() + appId;
//		System.out.println("urlA = " + urlA);
		final String v = HttpUtil.get(urlA);

//		System.out.println("v = " + v);

		final ObjectMapper mapper = new ObjectMapper();
		CR<AppResultDTO> cr = null;
		try {
			cr = mapper.readValue(v, new com.fasterxml.jackson.core.type.TypeReference<CR<AppResultDTO>>() {
			});
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}

		return cr;
	}

}
