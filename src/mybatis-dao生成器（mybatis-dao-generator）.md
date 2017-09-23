### 1.背景
公司的项目基于MyBatis，需要生成每个表DAO，方式很多，有IDE的插件，也可以下载简单的代码，运行main方法，两个都很麻烦，所以就决定基于main方法，结合swing，做一个简单的生成器，如下图：

![image](http://od6z2tvuj.bkt.clouddn.com/mybatis_dao_generator)
======================================================================

### 2.所用技术

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)
* [Download Latest](https://github.com/mybatis/mybatis-3/releases)
* [See the docs of MyBatis](http://mybatis.github.io/mybatis-3)
* [See the Introduction to MyBatis Generator](http://www.mybatis.org/generator/)


### 3.遇到的坑
1. **配置文件中的targetProject的定义不清楚**    
通过查阅源码，发现targetProject的是：生成文件的路径，要求必须存在的，不会自动创建，而targetPackage的定义是：生成类的包路径，不存在就会创建。。。。Project这命名,无法吐槽。。。用targetPath都好理解咯，可能是我英文不过关
2. **配置文件的定位**   
在IDE运行可以，当导出jar独立运行时却发现找不到配置文件，无论这么试都不行
我的项目路径是
>cn.com.bluemoon    
主类    
配置xml

通过研究发现了两种获取java资源路径的方式
1. 基于系统路径的定位
```java 
File configFile=new File(System.getProperty("user.dir")+"\\generatorConfig.xml
```
这种方式相当于读取外部资源，要求，用户将配置文件和jar放在一起，其中user.dir路径是jar所在路径
2. 基于资源的路径
```java
InputStream is=GeneratorSqlmap.class.getResourceAsStream("generatorConfig.xml");
File configFile=GeneratorSqlmap.class.getResource("generatorConfig.xml").getFile();
ClassLoader.getResourceAsStream ("some/pkg/resource.properties");
Class.getResourceAsStream ("/some/pkg/resource.properties");
ResourceBundle.getBundle ("some.pkg.resource");
```
Class下的getResourceAsStream需要绝对路径
ClassLoarder下的getResourceAsStream不需要绝对路径
>You can't get a File object (since it's no longer a file once it's in the .jar), but you should be able to get it as a stream via getResourceAsStream(path);, where path is the complete path to your class.


**参考资料**
* [java路径全接触](http://note.youdao.com/noteshare?id=20023441e3261122ffc2ba0df823e1cb)
* [Can't find resource file after exporting to a runnable JAR](https://stackoverflow.com/questions/18151072/cant-find-resource-file-after-exporting-to-a-runnable-jar)
* [Smartly load your properties](https://www.javaworld.com/article/2077352/java-se/smartly-load-your-properties.html)