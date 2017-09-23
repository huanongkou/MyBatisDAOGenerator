package cn.com.bluemoon;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

	public static String generator(String tableName, String packagPath) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			// String
			// path=GeneratorSqlmap.class.getClassLoader().getResource(".").getPath()+"\\cn\\com\\bluemoon\\";
			File configFile = null;
			//configFile = new File("classpath*:/generatorConfig.xml");
			// configFile=new  File(System.getProperty("user.dir")+"\\generatorConfig.xml");
			File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
			String desktopPath = desktopDir.getAbsolutePath();
			ConfigurationParser cp = new ConfigurationParser(warnings);
			//System.out.println(GeneratorSqlmap.class.getResource("generatorConfig.xml").getPath());
			System.out.println(Class.class.getResource("/cn/com/bluemoon/generatorConfig.xml").getPath());
			//System.out.println(Class.class.getClassLoader().getResource("cn/com/bluemoon/generatorConfig.xml").getPath());
			//System.out.println(Class.class.getResource("/prop/generatorConfig.xml").getPath());
			Configuration config = cp
					.parseConfiguration(GeneratorSqlmap.class.getResourceAsStream("/cn/com/bluemoon/generatorConfig.xml"));// cp.parseConfiguration(configFile);
			List<Context> contexts = config.getContexts();
			Context context = contexts.get(0);
			context.getJavaModelGeneratorConfiguration().setTargetProject(desktopPath);
			context.getJavaModelGeneratorConfiguration().setTargetPackage(packagPath + ".po");
			//System.out.println(context.getJavaModelGeneratorConfiguration().getTargetPackage());
			//System.out.println(context.getJavaModelGeneratorConfiguration().getTargetProject());
			context.getSqlMapGeneratorConfiguration().setTargetProject(desktopPath);
			context.getSqlMapGeneratorConfiguration().setTargetPackage(packagPath + ".mapper");
			context.getJavaClientGeneratorConfiguration().setTargetProject(desktopPath);
			context.getJavaClientGeneratorConfiguration().setTargetPackage(packagPath + ".mapper");
			//System.out.println(context.getSqlMapGeneratorConfiguration().getTargetProject());
			//System.out.println(context.getSqlMapGeneratorConfiguration().getTargetPackage());
			context.getTableConfigurations().get(0).setTableName(tableName);
			//System.out.println(context.getTableConfigurations().get(0).getTableName());
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			return "生成成功，请去桌面查看";
		} catch (Exception e) {
			return e.getStackTrace().toString();
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(GeneratorSqlmap.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(GeneratorSqlmap.class.getResource(""));
		System.out.println(GeneratorSqlmap.class.getResource("/")); // Class文件所在路径
		System.out.println(new File("/").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(GeneratorSqlmap.class.getClassLoader().getResource(".").getPath());
		System.out.println(FileSystemView.getFileSystemView().getHomeDirectory());
		try {
			// GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			// generatorSqlmap.generator();
			System.out.println("over");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
