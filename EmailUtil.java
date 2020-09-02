package Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.zip.DataFormatException;

/*
 maven依赖
 ----------------------------------
  <dependency>
     <groupId>com.sun.mail</groupId>
     <artifactId>javax.mail</artifactId>
     <version>VERSION</version>
  </dependency>
  <dependency>
     <groupId>javax.mail</groupId>
     <artifactId>javax.mail-api</artifactId>
     <version>VERSION</version>
  </dependency>
 ----------------------------------
 */

public class EmailUtil {
    private static BufferedReader stdIn =
            new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new PrintWriter(System.out, true);
    private static PrintWriter stdErr = new PrintWriter(System.err, true);

    public static void send(String mail, String content) throws MessagingException, DataFormatException {
        String match = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        if (mail.matches(match)) {
            String smtp = "smtp.qq.com";
            final String username = "2697666955@qq.com";
            final String password = "rfvghaocfbjydhbj";
            // 连接到SMTP服务器587端口:
            Properties props = new Properties();
            props.put("mail.smtp.host", smtp); // SMTP主机名
            props.put("mail.smtp.port", "587"); // 主机端口号
            props.put("mail.smtp.auth", "true"); // 是否需要用户认证
            props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
            // 获取Session实例:
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            session.setDebug(false);
            MimeMessage message = new MimeMessage(session);
            // 设置发送方地址:
            message.setFrom(new InternetAddress("2697666955@qq.com"));
            // 设置接收方地址:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            // 设置邮件主题:
            message.setSubject("智能制造云工厂", "UTF-8");
            // 设置邮件正文:
            message.setText(content, "UTF-8");
            // 发送:
            Transport.send(message);
        }else {
            throw new DataFormatException("Wrong Mailbox");
        }
    }

}
