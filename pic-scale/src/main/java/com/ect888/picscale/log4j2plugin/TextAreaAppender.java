package com.ect888.picscale.log4j2plugin;


import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;



/**
 * 自定义Appender，继承 AbstractAppender 只需要覆盖自已想要的方法即可<br>
 * 类上面的注解是用来设置配置文件中的标签。
 */
@Plugin(name = "TextArea", category = "Core", elementType = "appender", printObject = true)
public class TextAreaAppender extends AbstractAppender {
 
    //需要实现的构造方法，直接使用父类就行
    protected TextAreaAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout,
            final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions,null);
    }
 

    
    @Override
    public void append(LogEvent event) {
        final byte[] bytes = getLayout().toByteArray(event);//日志二进制文件，输出到指定位置就行
        //下面这个是要实现的自定义逻辑
        try {
			Util.queue.offer(new String(bytes),200,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
 
    // 下面这个方法可以接收配置文件中的参数信息
    @PluginFactory
    public static TextAreaAppender createAppender(@PluginAttribute("name") String name,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImpl");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new TextAreaAppender(name, filter, layout, ignoreExceptions);
    }
 
}