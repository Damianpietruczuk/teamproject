package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) {

        final String username = "test.kurs.123123@gmail.com";
        final String password = "Test1234@";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("crimson.kuba@gmail.com")
            );
            message.setSubject("Testing");
            message.setText("Witam,"
                    + "\n\n Tutaj mail testowy");

            Transport.send(message);

            System.out.println("Sukces");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


//    public static void prepareMessage(Session session, String action String initialValue, String finalValue, String email){
//
//
//        try {
//            Message message1 = new MimeMessage(session);
//            message1.setFrom(new InternetAddress("from@gmail.com"));
//            message1.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse("dampiet34@wp.pl")
//            );
//            message1.setSubject("Testing");
//            message1.setText("Witam,"
//                    + "\n\n Tutaj mail testowy");
//            message1.setText("Witam");
//
//            Transport.send(message1);
//
//            System.out.println("Sukces");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

}
