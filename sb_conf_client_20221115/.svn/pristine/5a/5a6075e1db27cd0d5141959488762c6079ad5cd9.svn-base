package com.vo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vo.client.test.IdConf;

import cn.hutool.captcha.ICaptcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.convert.ReadingConverter;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年12月5日
 *
 */
@RestController
public class API {

	@Value("${spring.datasource.url}")
	String datasourceURL;

	@Autowired
	IdConf idConf;
	@GetMapping
	public String index() {
		System.out.println(
				java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "API.index()");

		System.out.println("idConf = " + this.idConf);
		System.out.println("idConf.id[0] = " + this.idConf.getId().get(0));
		System.out.println("datasourceURL = " + this.datasourceURL);

		return this.idConf.toString();
	}

}
