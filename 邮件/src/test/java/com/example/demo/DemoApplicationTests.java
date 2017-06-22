package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.Template;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private MailService mailService;

	@Test
	public void contextLoads() {
		mailService.sendSimpleMail("lf@techsun.com.cn","test mail", "来自未来的你。");
	}

	@Test
	public void sendHtml() {
		String content="<html>\n" +
				"<body>\n" +
				"    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
				"</body>\n" +
				"</html>";
		mailService.sendHtmlMail("lf@techsun.com.cn","test simple mail",content);
	}

	@Test
	public void sendAttachmentsMail() {
		String filePath="/Users/archerlj/Desktop/李飞_工作日志170622.xls";
		mailService.sendAttachmentsMail("lf@techsun.com.cn", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	@Test
	public void sendInlineResourceMail() {
		String rscId = "test";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "/Users/archerlj/Downloads/12481498.jpeg";

		mailService.sendInlineResourceMail("lf@techsun.com.cn", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

	@Autowired
	TemplateEngine templateEngine;

	@Test
	public void sendTemplateMail() {
		//创建邮件正文
		Context context = new Context();
		context.setVariable("id", "006");
		context.setVariable("name", "archerLj");
		String emailContent = templateEngine.process("emailTemplate", context);

		mailService.sendHtmlMail("lf@techsun.com.cn","主题：这是模板邮件",emailContent);
	}

}
