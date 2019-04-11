package com.ect888.picscale.busi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ect888.picscale.config.Config;
import com.ect888.picscale.log4j2plugin.Util;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * 界面启动入口
 * 
 * @author fanyj
 *
 */
@Component
@Slf4j
public class FrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	final JTextArea textaera = new JTextArea();

	final JButton sendButton = new JButton("缩放");
	final JButton fileInput = new JButton("输入目录");
	final JButton dirOutput = new JButton("输出目录");
	final JButton clearButton = new JButton("清空日志");
	
	final JTextField input_TextField = new JTextField();
	final JTextField output_TextField = new JTextField();

	@Autowired
	public FrameMain(PicUtil picUtil,Config config) {
		setTitle("图片缩放");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));

		
		northPanel.add(fileInput);
		northPanel.add(input_TextField);
		
		
		northPanel.add(dirOutput);
		northPanel.add(output_TextField);
		

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(sendButton);
		southPanel.add(clearButton);

		north.add(northPanel, BorderLayout.NORTH);
		north.add(southPanel, BorderLayout.SOUTH);

		JScrollPane imgSp = new JScrollPane();
		imgSp.setViewportView(textaera);
		imgSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		imgSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(north, BorderLayout.NORTH);
		contentPane.add(imgSp, BorderLayout.CENTER);

		sendButton.addActionListener((e) -> {
			sendButton.setEnabled(false);
			if (null == input) {
				log.error("未选择输入文件");
				sendButton.setEnabled(true);
				return;
			}

			if (null == output) {
				log.error("未选择输出目录");
				sendButton.setEnabled(true);
				return;
			}

			int targetSize = config.getTargetSize();
			int tryTimes = config.getTryTimes();
			byte[] picTemp = picUtil.compressPic(input, targetSize, tryTimes);

			String outFile = output.getAbsolutePath() + "out_" + input.getName();

			try {
				Thumbnails.of(new ByteArrayInputStream(picTemp)).scale(1).toFile(outFile);
			} catch (IOException ee) {
				log.error("写出结果文件" + outFile + "出错", ee);
			}

			log.info("处理完成" + outFile);
			sendButton.setEnabled(true);
		});
		fileInput.addActionListener((e) -> {
			JFileChooser chooser = new JFileChooser();
			int mode = JFileChooser.FILES_ONLY;
			chooser.setFileSelectionMode(mode);
			
			chooser.setFileFilter(new FileFilter() {

				@Override
				public boolean accept(File f) {
					int i=f.getName().lastIndexOf(".");
					if(i<0)
						return false;
					
					String suffix=f.getName().substring(i);
					return config.getSupportSuffix().contains(suffix);
				}

				@Override
				public String getDescription() {
					return config.getSupportSuffix()+"";
				}
				
			});
			
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				input = chooser.getSelectedFile();
				input_TextField.setText(input.getAbsolutePath());
				log.info("选择输入文件" + input.getAbsolutePath());
			} else {
				log.warn("未选择输入文件");
			}
		});

		dirOutput.addActionListener((e) -> {
			JFileChooser chooser = new JFileChooser();
			int mode = JFileChooser.DIRECTORIES_ONLY;
			chooser.setFileSelectionMode(mode);
			
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				output = chooser.getSelectedFile();
				output_TextField.setText(output.getAbsolutePath());
				log.info("选择输出目录" + output.getAbsolutePath());
			} else {
				log.warn("未选择输出目录");
			}
		});

		Thread thread = new Thread(() -> {
			while (true) {
				String hints=null;
				try {
					hints = Util.queue.poll(200, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					log.error("", e);
					return;
				}
				if(null!=hints) {
					textaera.append("\r\n" + hints);
				}
			}

		});
		thread.setDaemon(true);
		thread.start();
		
		clearButton.addActionListener((e) -> {
			textaera.setText("");
			log.info("已清空日志");
		});
		
		log.info("初始化完成！压缩图片目标大小"+config.getTargetSize()
		+"B,最大尝试次数"+config.getTryTimes()
		+",支持的文件后缀列表"+config.getSupportSuffix());
	}

	public JButton getSendButton() {
		return sendButton;
	}

	File input;
	File output;

}
