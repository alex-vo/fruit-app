package controllers;

import play.api.i18n.Lang;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.Properties;

public class Application extends Controller {

    public static Result index(){
        changeLang("lv");
        System.out.println("AAAA");
        return ok(index.render());
    }

    public static Result submitTrial(){
        Lang.apply("lv");
        System.out.println(Messages.get("hello"));
        String phoneOrEmail = request().body().asFormUrlEncoded().get("phoneOrEmail")[0];
        final String username = "alex.vo92@gmail.com";
        final String password = "alex37128899747";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("alex.vo92@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("avoroncovs@gmail.com"));
//            message.setSubject("Testing Subject");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n No spam to my email, please! " + phoneOrEmail);
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        return ok();
    }

}
