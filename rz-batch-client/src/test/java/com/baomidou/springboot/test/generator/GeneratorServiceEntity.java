package com.baomidou.springboot.test.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.ect888.RzBatchClientApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RzBatchClientApplication.class)
public class GeneratorServiceEntity {

    @Autowired
    private DynamicDataSourceProperties properties;

	@Test
	public void generateCode() {
		String packageName = "com.ect888";
		boolean serviceNameStartWithI = false;// user -> UserService, 设置成true: user -> IUserService
		
		//tbl_vbaonl_ptyproduct_revenue//日收入报表
		//tbl_vbaonl_product_channel_cost//成本统计表
		//view_vbaonl_bill_aging//账龄表视图
		generateByTables(serviceNameStartWithI, packageName, "tbl_vbaonl_trans_1","tbl_vbaonl_trans_2");
	}

	private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {

		log.info("properties="+JSON.toJSONString(properties));
		
		DataSourceProperty dataSourceProperties=properties.getDatasource().get("mysql");
		
		log.info("dataSourceProperties="+JSON.toJSONString(dataSourceProperties));
		
		GlobalConfig config = new GlobalConfig();
		String dbUrl = dataSourceProperties.getUrl();
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL).setUrl(dbUrl).setUsername(dataSourceProperties.getUsername()).setPassword(dataSourceProperties.getPassword())
				.setDriverName(dataSourceProperties.getDriverClassName());// com.mysql.jdbc.Driver
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true)
				.setColumnNaming(NamingStrategy.underline_to_camel)
				.setNaming(NamingStrategy.no_change)//防止tbl_vbaonl_trans_2被弄成tbl_vbaonl_trans2
				.setEntityLombokModel(true)
				.setRestControllerStyle(true)
				//.setSuperControllerClass("com.baomidou.ant.common.BaseController")
				//.setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
				.setInclude(tableNames)// 修改替换成你需要的表名，多个表名传数组
				.setSuperEntityColumns("id")
				.setControllerMappingHyphenStyle(true);
		config.setActiveRecord(false).setAuthor("fanyj").setOutputDir("e:\\codeGen").setFileOverride(true);
		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}
		new AutoGenerator().setGlobalConfig(config).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
				.setPackageInfo(
						new PackageConfig().setParent(packageName).setController("controller").setEntity("entity"))
				// 切换为 freemarker 模板引擎
				.setTemplateEngine(new FreemarkerTemplateEngine())
				.execute();
		
		log.info("generateByTables done ");
	}
}

