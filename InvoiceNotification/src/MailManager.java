/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailManager {
     private static final String SMTP_AUTH_USER = Properties.getProperty("Mail.User").toString();
    private static final String SMTP_AUTH_PWD  = Properties.getProperty("Mail.pwd").toString();
    private static final String SMTP_HOST  = Properties.getProperty("Mail.Host").toString();
    private static final String SMTP_PORT  = Properties.getProperty("Mail.Port").toString();
    private static final String MAIL_FROM  = Properties.getProperty("Mail.from").toString();
    private static final String MAIL_COMPANY  = Properties.getProperty("Mail.company").toString();

    public static String submitResume(){
       String to = MAIL_COMPANY;
           //  System.out.println("to---"+to);
        String result="fail";
        /** The from is used for storing the from address. */
        String from = MAIL_FROM;
        
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        
        /**The host is used for storing the IP address of mail */
        
        /**The props is instance variabel to <code>Properties</code> class */
        java.util.Properties props = new java.util.Properties();
        
        /**Here set smtp protocal to props */
        props.setProperty("mail.transport.protocol", "smtp");
        
        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /** Here set the authentication for the host **/
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        
        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
       // mailSession.setDebug(true);
         mailSession.setDebug(false);
        Transport transport;
        try {
            transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Applying for ");
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mr.javaprogrammer@gmail.com"));
            
            
            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");
            
            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();
                     htmlText.append("<!DOCTYPE html>");
            htmlText.append("<html>");
            htmlText.append("<head>");
            htmlText.append("<meta charset='utf-8'>");
            htmlText.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            htmlText.append("<meta http-equiv='X-UA-Compatible' content='IE=edge' />");
            htmlText.append("<style type='text/css'>");
            /* CLIENT-SPECIFIC STYLES */
            htmlText.append("body, table, td, a{-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;}"); /* Prevent WebKit and Windows mobile changing default text sizes */
            htmlText.append("table, td{mso-table-lspace: 0pt; mso-table-rspace: 0pt;}"); /* Remove spacing between tables in Outlook 2007 and up"); */
            htmlText.append("img{-ms-interpolation-mode: bicubic;}"); /* Allow smoother rendering of resized image in Internet Explorer */
            /* RESET STYLES */
            htmlText.append("img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none;}");
            htmlText.append("table{border-collapse: collapse !important;}");
            htmlText.append("{height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important;}");
            /* iOS BLUE LINKS */
            htmlText.append("a[x-apple-data-detectors] {");
            htmlText.append("color: inherit !important;");
            htmlText.append("text-decoration: none !important;");
            htmlText.append("font-size: inherit !important;");
            htmlText.append("font-family: inherit !important;");
            htmlText.append("font-weight: inherit !important;");
            htmlText.append("line-height: inherit !important;");
            htmlText.append("}");
            /* MOBILE STYLES */
            htmlText.append("@media screen and (max-width: 525px) {");
            /* ALLOWS FOR FLUID TABLES */
            htmlText.append(".wrapper {");
            htmlText.append("width: 100% !important;");
            htmlText.append("max-width: 100% !important;");
            htmlText.append("}");
            /* ADJUSTS LAYOUT OF LOGO IMAGE */
            htmlText.append(".logo img {");
            htmlText.append("margin: 0 auto !important;");
            htmlText.append("}");
            /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */
            htmlText.append(".mobile-hide {");
            htmlText.append("display: none !important;");
            htmlText.append("}");
            htmlText.append(".img-max {");
            htmlText.append("max-width: 100% !important;");
            htmlText.append("width: 100% !important;");
            htmlText.append("height: auto !important;");
            htmlText.append("}");
            /* FULL-WIDTH TABLES */
            htmlText.append(".responsive-table {");
            htmlText.append("width: 100% !important;");
            htmlText.append("}");
            /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */
            htmlText.append(".padding {");
            htmlText.append("padding: 10px 5% 15px 5% !important;");
            htmlText.append("}");
            htmlText.append(".padding-meta {");
            htmlText.append("padding: 30px 5% 0px 5% !important;");
            htmlText.append("text-align: center;");
            htmlText.append("}");
            htmlText.append(".padding-copy {");
            htmlText.append("padding: 10px 5% 10px 5% !important;");
            htmlText.append("text-align: center;");
            htmlText.append("}");
            htmlText.append(".no-padding {");
            htmlText.append(" padding: 0 !important;");
            htmlText.append("}");
            htmlText.append(".section-padding {");
            htmlText.append("padding: 50px 15px 50px 15px !important;");
            htmlText.append("}");
            /* ADJUST BUTTONS ON MOBILE */
            htmlText.append(".mobile-button-container {");
            htmlText.append("margin: 0 auto;");
            htmlText.append("width: 100% !important;");
            htmlText.append("}");
            htmlText.append(".mobile-button {");
            htmlText.append("padding: 15px !important;");
            htmlText.append("border: 0 !important;");
            htmlText.append("font-size: 16px !important;");
            htmlText.append("display: block !important;");
            htmlText.append("}");
            htmlText.append("}");
            /* ANDROID CENTER FIX */
            htmlText.append("div[style*='margin: 16px 0;'] { margin: 0 !important; }");
            htmlText.append("</style>");
            htmlText.append("</head>");
            htmlText.append("<body style='margin: 0 !important; padding: 0 !important;'>");

            htmlText.append("<div style='display: none; font-size: 1px; color: #fefefe;line-height: 1px; font-family: Helvetica, Arial, sans-serif;max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;'></div>");
            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center'>");

            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 500px;' class='wrapper'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center' valign='top' style='padding: 15px 0;' class='logo'>");
            htmlText.append("<a href='"+Properties.getProperty("Company.Url") +"' target='_blank'>");
            htmlText.append("<img alt='Logo' src='"+Properties.getProperty("Company.Logo") +"' width='165' height='auto' style='display: block; font-family: Helvetica, Arial, sans-serif; color: #ffffff; font-size: 16px;' border='0'>");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");

            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center' style='padding: 5px;'>");
            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 500px;' class='responsive-table'>");
            htmlText.append("<tr>");
            htmlText.append("<td>");

            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center' style='font-size: 26px; font-family: calibri; color: #2368a0; padding-top: 10px;' class='padding-copy'><b>Cadidate Details</b></td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");

            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center' style='padding: 15px;' class='padding'>");

            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 500px;' class='responsive-table'>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='left' style='padding: 5px 0 5px 0; font-size: 14px; line-height: 25px; font-family: calibri; color: #232527;' class='padding-copy'>"
                    + "Hello <b>Team,</b><br>Below person wants to join with us.Please find  the details below.");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='justify' style='padding: 5px 0 5px 0; border-top: 1px dashed #2368a0; border-bottom: 1px dashed #2368a0; font-size: 14px; line-height: 25px; font-family: calibri; color: #232527;' class='padding-copy'>");
           /* htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Name :</b> "+details.getFullName()+"<br>");
            htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Email:</b> "+details.getEmail()+"</b><br>");
            htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Phone :</b> "+details.getMobileNumber()+"</b><br>");
            htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Qualification :</b> "+details.getQualification()+"</b><br>");
            htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Job Title :</b> "+details.getJobTitle()+"</b><br>");
            htmlText.append("<b style='font-size: 14px; color: #ef4048;'>Total Experience :</b> "+details.getExperience()+"</b><br>");

*/
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='justify' style='padding: 5px 0 5px 0; border-top: 1px dashed #2368a0;  font-size: 14px; line-height: 25px; font-family: calibri; color: #232527;' class='padding-copy'>");
            htmlText.append("<b style='font-size: 14px; color: #2368a0;'>Skills:</b>");
            /*htmlText.append("<p>"+details.getSkills()+"</p>");*/
            htmlText.append("</td>");
            htmlText.append("</tr>");
           /* if(details.getAdditionalInfo()!=null && !"".equals(details.getAdditionalInfo())){
            htmlText.append("<tr>");
            htmlText.append("<td align='justify' style='padding: 5px 0 5px 0; border-top: 1px dashed #2368a0;  font-size: 14px; line-height: 25px; font-family: calibri; color: #232527;' class='padding-copy'>");
            htmlText.append("<b style='font-size: 14px; color: #2368a0;'>Additional Info :</b>");
            htmlText.append("<p>"+details.getAdditionalInfo()+"</p>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            }*/
            htmlText.append("</table>");
            htmlText.append("<table width='600' border='0' cellspacing='0' cellpadding='0' align='center'>"
                    + " <tr>\n"
                    + "<td>\n"
                    + "<div class='contentEditableContainer contentTextEditable'>"
                    + "<div class='contentEditable' style='text-align: center;'>"
                    + "<p style='text-align: justify; font-size: 14px;'><font color='#ff000' face='trebuchet ms'><i><b>*Note:</b> Do not reply to this email as this is an automated notification.</i>"
                    + " </font></p></div></div></td></tr><tr><td height='25'></td></tr></table>");


            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");

            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='left' style='padding: 5px 0 5px 0; font-size: 14px; line-height: 22px; font-family: calibri; color: #8c8c8c; font-style: normal;' class='padding-copy'>");
            htmlText.append("Thanks & Regards,<br>");

            htmlText.append("Shrewdsoft Inc. <br>");
            htmlText.append("Email:  info@shrewdsoft.com,  <br>");
            htmlText.append("Phone:  (302)525-4747,(302)502-0230.");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");

            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");

            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center' style='padding: 15px 0px;'>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center' style='max-width: 500px;' class='responsive-table'>");
            htmlText.append("<tr>");
            htmlText.append("<td width='200' align='center' style='text-align: center;'>");
            htmlText.append("<table width='200' cellpadding='0' cellspacing='0' align='center'>");
            htmlText.append("<tr>");
            htmlText.append("<td width='10'>");
            //  htmlText.append("<a href='https://www.facebook.com/miracle45625' target='_blank'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/facebook.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/googleplus.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/linkedin.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
//                                       htmlText.append("<td width='10'>");
//                                          htmlText.append("<a href='https://www.youtube.com/c/Team_MSS' target='_blank'>");
//                                          htmlText.append("<img src='http://www.miraclesoft.com/images/newsletters/youtube.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
//                                          htmlText.append("</a>");
//                                       htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/twitter.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td height='10'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center' style='font-size: 14px; line-height: 20px; font-family: calibri; color:#666666;'>&copy; 2016 Shrewdsoft Inc");
            htmlText.append("<br>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");


            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</body>");
            htmlText.append("</html>");


            //====================
            messageBodyPart.setContent(htmlText.toString(), "text/html");    
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
          //  String filename = details.getResumeFile().getAbsolutePath();
            String filename="D:\\Anand\\invoice.pdf";
            DataSource source = new FileDataSource(filename);

            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("invoice.pdf");
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // put everything together
            message.setContent(multipart);
            //================
                   
            // add it
            
            // put everything together
            
            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            transport.close();
            result="success";
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        }  catch (MessagingException ex) {
            ex.printStackTrace();
        }
            
            return result;
        }
     
     public static String resumeSubmitAcknowledgement(String personName,String toEmail){
    String to = toEmail;
            // System.out.println("to---"+to);
        String result="fail";
        /** The from is used for storing the from address. */
        String from = MAIL_FROM;
        
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        
        /**The host is used for storing the IP address of mail */
        
        /**The props is instance variabel to <code>Properties</code> class */
        java.util.Properties props = new java.util.Properties();
        
        /**Here set smtp protocal to props */
        props.setProperty("mail.transport.protocol", "smtp");
        
        //**Here set the address of the host to props */
        props.setProperty("mail.host", SMTP_HOST);
        props.put("mail.smtp.starttls.enable", "true");
        /** Here set the authentication for the host **/
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        
        Authenticator auth = new SMTPAuthenticator();
        // Session mailSession = Session.getDefaultInstance(props, null);
        Session mailSession = Session.getDefaultInstance(props, auth);
       // mailSession.setDebug(true);
         mailSession.setDebug(false);
        Transport transport;
        try {
           transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject("Your details submitted successfully!");
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("mchennu@miraclesoft.com"));


            // This HTML mail have to 2 part, the BODY and the embedded image
            //
            MimeMultipart multipart = new MimeMultipart("related");

            // first part  (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            StringBuilder htmlText = new StringBuilder();
            htmlText.append("<!DOCTYPE html>");
            htmlText.append("<html>");
            htmlText.append("<head>");
            htmlText.append("<meta charset='utf-8'>");
            htmlText.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            htmlText.append("<meta http-equiv='X-UA-Compatible' content='IE=edge' />");
            htmlText.append("<style type='text/css'>");
            /* CLIENT-SPECIFIC STYLES */
            htmlText.append("body, table, td, a{-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;}"); /* Prevent WebKit and Windows mobile changing default text sizes */
            htmlText.append("table, td{mso-table-lspace: 0pt; mso-table-rspace: 0pt;}"); /* Remove spacing between tables in Outlook 2007 and up"); */
            htmlText.append("img{-ms-interpolation-mode: bicubic;}"); /* Allow smoother rendering of resized image in Internet Explorer */
            /* RESET STYLES */
            htmlText.append("img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none;}");
            htmlText.append("table{border-collapse: collapse !important;}");
            htmlText.append("{height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important;}");
            /* iOS BLUE LINKS */
            htmlText.append("a[x-apple-data-detectors] {");
            htmlText.append("color: inherit !important;");
            htmlText.append("text-decoration: none !important;");
            htmlText.append("font-size: inherit !important;");
            htmlText.append("font-family: inherit !important;");
            htmlText.append("font-weight: inherit !important;");
            htmlText.append("line-height: inherit !important;");
            htmlText.append("}");
            /* MOBILE STYLES */
            htmlText.append("@media screen and (max-width: 525px) {");
            /* ALLOWS FOR FLUID TABLES */
            htmlText.append(".wrapper {");
            htmlText.append("width: 100% !important;");
            htmlText.append("max-width: 100% !important;");
            htmlText.append("}");
            /* ADJUSTS LAYOUT OF LOGO IMAGE */
            htmlText.append(".logo img {");
            htmlText.append("margin: 0 auto !important;");
            htmlText.append("}");
            /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */
            htmlText.append(".mobile-hide {");
            htmlText.append("display: none !important;");
            htmlText.append("}");
            htmlText.append(".img-max {");
            htmlText.append("max-width: 100% !important;");
            htmlText.append("width: 100% !important;");
            htmlText.append("height: auto !important;");
            htmlText.append("}");
            /* FULL-WIDTH TABLES */
            htmlText.append(".responsive-table {");
            htmlText.append("width: 100% !important;");
            htmlText.append("}");
            /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */
            htmlText.append(".padding {");
            htmlText.append("padding: 10px 5% 15px 5% !important;");
            htmlText.append("}");
            htmlText.append(".padding-meta {");
            htmlText.append("padding: 30px 5% 0px 5% !important;");
            htmlText.append("text-align: center;");
            htmlText.append("}");
            htmlText.append(".padding-copy {");
            htmlText.append("padding: 10px 5% 10px 5% !important;");
            htmlText.append("text-align: center;");
            htmlText.append("}");
            htmlText.append(".no-padding {");
            htmlText.append(" padding: 0 !important;");
            htmlText.append("}");
            htmlText.append(".section-padding {");
            htmlText.append("padding: 50px 15px 50px 15px !important;");
            htmlText.append("}");
            /* ADJUST BUTTONS ON MOBILE */
            htmlText.append(".mobile-button-container {");
            htmlText.append("margin: 0 auto;");
            htmlText.append("width: 100% !important;");
            htmlText.append("}");
            htmlText.append(".mobile-button {");
            htmlText.append("padding: 15px !important;");
            htmlText.append("border: 0 !important;");
            htmlText.append("font-size: 16px !important;");
            htmlText.append("display: block !important;");
            htmlText.append("}");
            htmlText.append("}");
            /* ANDROID CENTER FIX */
            htmlText.append("div[style*='margin: 16px 0;'] { margin: 0 !important; }");
            htmlText.append("</style>");
            htmlText.append("</head>");
            htmlText.append("<body style='margin: 0 !important; padding: 0 !important;'>");

            htmlText.append("<div style='display: none; font-size: 1px; color: #fefefe;line-height: 1px; font-family: Helvetica, Arial, sans-serif;max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;'></div>");
            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center'>");

            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 500px;' class='wrapper'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center' valign='top' style='padding: 15px 0;' class='logo'>");
            htmlText.append("<a href='"+Properties.getProperty("Company.Url") +"' target='_blank'>");
            htmlText.append("<img alt='Logo' src='"+Properties.getProperty("Company.Logo") +"' width='165' height='auto' style='display: block; font-family: Helvetica, Arial, sans-serif; color: #ffffff; font-size: 16px;' border='0'>");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");

            htmlText.append("</td>");
            htmlText.append("</tr>");

            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center' style='padding: 15px;' class='padding'>");

            htmlText.append("<table border='0' cellpadding='0' cellspacing='0' width='100%' style='max-width: 500px;' class='responsive-table'>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='left' style='padding: 5px 0 5px 0; font-size: 14px; line-height: 25px; font-family: calibri; color: #232527;' class='padding-copy'>"
                    + "Hello <b>"+personName+",</b><br>Thank You so much for reaching out to us. One of our Team Members will call you back soon.");
            htmlText.append("</td>");
            htmlText.append("</tr>");



            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");

            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            htmlText.append("<tr>");
            htmlText.append("<td align='left' style='padding: 5px 0 5px 0; font-size: 14px; line-height: 22px; font-family: calibri; color: #8c8c8c; font-style: normal;' class='padding-copy'>");
            htmlText.append("Thanks & Regards,<br>");

            htmlText.append("Shrewdsoft Inc. <br>");
            htmlText.append("Email:  info@shrewdsoft.com,  <br>");
            htmlText.append("Phone:  (302)525-4747,(302)502-0230.");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td>");

            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");

            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td bgcolor='#ffffff' align='center' style='padding: 15px 0px;'>");
            htmlText.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center' style='max-width: 500px;' class='responsive-table'>");
            htmlText.append("<tr>");
            htmlText.append("<td width='200' align='center' style='text-align: center;'>");
            htmlText.append("<table width='200' cellpadding='0' cellspacing='0' align='center'>");
            htmlText.append("<tr>");
            htmlText.append("<td width='10'>");
            //  htmlText.append("<a href='https://www.facebook.com/miracle45625' target='_blank'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/facebook.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/googleplus.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/linkedin.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
//                                       htmlText.append("<td width='10'>");
//                                          htmlText.append("<a href='https://www.youtube.com/c/Team_MSS' target='_blank'>");
//                                          htmlText.append("<img src='http://www.miraclesoft.com/images/newsletters/youtube.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
//                                          htmlText.append("</a>");
//                                       htmlText.append("</td>");
            htmlText.append("<td width='10'>");
            htmlText.append("<a href='' target='_blank'>");
            htmlText.append("<img src='http://www.shrewdsoft.com:8080/Shrewdsoft/mailImages/twitter.png' alt='facebook' width='26' height='auto' data-max-width='40' data-customIcon='true' >");
            htmlText.append("</a>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td height='10'>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("<tr>");
            htmlText.append("<td align='center' style='font-size: 14px; line-height: 20px; font-family: calibri; color:#666666;'>&copy; 2016 Shrewdsoft Inc");
            htmlText.append("<br>");
            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");


            htmlText.append("</td>");
            htmlText.append("</tr>");
            htmlText.append("</table>");
            htmlText.append("</body>");
            htmlText.append("</html>");


            //====================
            messageBodyPart.setContent(htmlText.toString(), "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            //System.out.println("Mail Sent ----->");
            transport.close();
            result="success";
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        }  catch (MessagingException ex) {
            ex.printStackTrace();
        }
            
            return result;
        }
    
      
    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        
      
        
         
        public PasswordAuthentication getPasswordAuthentication() {
            
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
