package com.example.demo;

/**
 * Created by archerlj on 2017/6/21.
 */
public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
    public void sendHtmlMail(String to, String subject, String content);
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
