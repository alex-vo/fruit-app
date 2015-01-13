package controllers;

import play.api.i18n.Lang;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.thanks;
import views.html.thanks_account;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Application extends Controller {

    public static Result changeLanguage(String lang){
        changeLang(lang);
        return redirect("/");
    }

    public static Result index(){
        return ok(index.render());
    }

    public static Result submitTrial(){
        String phoneOrEmail = request().body().asFormUrlEncoded().get("phoneOrEmail")[0];
        final String username = "avoroncovs@gmail.com";
        final String password = "alex28899747";

        String host = "smtp.gmail.com";
        String from = "avoroncovs@gmail.com";
        String pass = "alex28899747";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("avoroncovs@gmail.com"));
            message.setSubject(Messages.get("new_trial", Lang.get("ru")), "utf-8");
            message.setText(Messages.get("hello_email", Lang.get("ru"))
                    + "\n\n " + Messages.get("new_trial_message", Lang.get("ru"))
                    + "\n " + Messages.get("phone_or_email", Lang.get("ru")) + ": " + phoneOrEmail, "utf-8");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ok(thanks.render());
    }

    public static Result makeRequest(){
        String greenApples = request().body().asFormUrlEncoded().get("green_apples")[0];
        String bananas = request().body().asFormUrlEncoded().get("bananas")[0];
        String redApples = request().body().asFormUrlEncoded().get("red_apples")[0];
        String pears = request().body().asFormUrlEncoded().get("pears")[0];
        String mandarines = request().body().asFormUrlEncoded().get("mandarines")[0];
        String seasonFruits = request().body().asFormUrlEncoded().get("season_fruits")[0];
        String phoneOrEmail = request().body().asFormUrlEncoded().get("phoneOrEmail")[0];
        final String username = "avoroncovs@gmail.com";
        final String password = "alex28899747";

        String host = "smtp.gmail.com";
        String from = "avoroncovs@gmail.com";
        String pass = "alex28899747";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("avoroncovs@gmail.com"));
            message.setSubject(Messages.get("new_order", Lang.get("ru")), "utf-8");
            message.setText(Messages.get("hello_email", Lang.get("ru"))
                    + "\n\n " + Messages.get("new_order_message", Lang.get("ru"))
                    + "\n " + Messages.get("green_apples", Lang.get("ru")) + ": " + greenApples
                    + "\n " + Messages.get("bananas", Lang.get("ru")) + ": " + bananas
                    + "\n " + Messages.get("red_apples", Lang.get("ru")) + ": " + redApples
                    + "\n " + Messages.get("pears", Lang.get("ru")) + ": " + pears
                    + "\n " + Messages.get("mandarines", Lang.get("ru")) + ": " + mandarines
                    + "\n " + Messages.get("season_fruits", Lang.get("ru")) + ": " + seasonFruits
                    + "\n " + Messages.get("phone_or_email", Lang.get("ru")) + ": " + phoneOrEmail, "utf-8");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ok(thanks_account.render());
    }

}
