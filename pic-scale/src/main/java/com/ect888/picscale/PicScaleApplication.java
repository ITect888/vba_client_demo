package com.ect888.picscale;

import java.awt.EventQueue;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ect888.picscale.busi.FrameMain;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PicScaleApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PicScaleApplication.class);
		ApplicationContext applicationContext = builder.headless(false).run(args);
		FrameMain swing = applicationContext.getBean(FrameMain.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing.setVisible(true);
				} catch (Exception e) {
					log.error("",e);
				}
			}
		});
	}

}
