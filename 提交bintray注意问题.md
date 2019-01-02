
1.加入JCenter有如下回复  
Hi, JCenter hosts java applications that follow maven convention. In addition to the .pom file, your version should include a binary jar file, a sources jar, and optionally a javadoc jar. Your files should be under a maven path layout. (see https://bintray.com/docs/usermanual/uploads/uploads_includingyourpackagesinjcenter.html) Once those files are added, we'll be glad to include your package in JCenter Regards, JFrog Support

解决办法：参考https://blog.csdn.net/ddnosh/article/details/79586301?utm_source=blogxgwz1。
build后运行gradle install才可以重新生成.jar文件。编辑包的地方可以上传

2. gradle bintrayUpload后生成的文件目录异常    
原因是：区分大小写。bintray创建的包名称和本地文件的包名称、配置文件的包名称都要一致（建议都用小写，保障通过）
https://github.com/hrdzkj/startForResult
	startForResult

3.打包和上传命令  
gradle install
gradle bintrayUpload
