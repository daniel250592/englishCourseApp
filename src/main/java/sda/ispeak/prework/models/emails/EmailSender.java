package sda.ispeak.prework.models.emails;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@Slf4j
public class EmailSender {

    private static final String HOST_NAME = "poczta.o2.pl";
    private static final int SMTP_PORT = 465;
    private static final String USER_NAME = "ispeakapp@o2.pl";
    private static final String PASSWORD = "Ispeak2000!";
    private static final boolean SSL_ON_CONNECT = true;

    public static void sendEmail(MyEmail myEmail){
        try{
        Email email = new SimpleEmail();
        email.setHostName(HOST_NAME);
        email.setSmtpPort(SMTP_PORT);
        email.setAuthenticator(new DefaultAuthenticator(USER_NAME, PASSWORD));
        email.setSSLOnConnect(SSL_ON_CONNECT);
        email.setFrom(USER_NAME);
        email.setSubject(myEmail.getSubject());
        email.setMsg(myEmail.getMessage());
        email.addTo(myEmail.getRecipient());
        log.info("Sending email to " + myEmail.getRecipient());
        email.send();
        log.info("Sending email succeed");
    } catch (EmailException e){
           log.error(e.getMessage());
        }
    }

}
