
----------使用说明--------------
0 新项目A中加入此应用的依赖
	<dependency>
		<groupId>com.vo</groupId>
		<artifactId>sb_conf_client_20221115</artifactId>
		<version>1.0-SNAPSHOT</version>
	</dependency>

1 application.properties 配置 	spring.profiles.active=xxx
  如：spring.profiles.active=re
  
2 新建第1步配置的re配置文件
	application-re.properties
	
3 在第2步的配置文件中配置好conf_server和conf_client相关信息
	conf.conf-url=http://localhost:11111/
	conf.app-id=1
	conf.appSecretKey=ABC
	conf.appName=conf_client_TEST
  然后配置需要配置的项
  	规则：
  		key={value}
  	conf只去{value}部分，和conf_server中的配置信息比对然后更新
  	如：client配置：
  		name={name}
  	server配置:
  		name={zhangsan}	
	
4 启动应用A,如第3步配置，则
	application-re.properties中的配置项
		name={name}
	会自动更新为
		name=zhangsan
	
  到此，conf_client使用流程完成
  
