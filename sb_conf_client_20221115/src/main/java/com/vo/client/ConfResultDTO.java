package com.vo.client;

import java.util.Date;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfResultDTO {

	private Integer id;
	private Integer appId;

	private String name;
	private String value;

	private Integer status;

	/**
	 * @see EnableStatusEnum
	 */
	private Integer enableStatus;

	private Date createTime;
}
