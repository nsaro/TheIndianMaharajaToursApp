package com.theindianmaharajatours.app.services;

import com.generated.code.model.QueryDto;
import com.theindianmaharajatours.app.dao.entities.TourEntity;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    private final String emailExecutiveId = System.getProperty("executiveEmailId");
    private final String emailExecutivePassword = System.getProperty("executiveEmailIdPassword");
    private final TourService tourService;

    EmailService(TourService tourService) {

        this.tourService = tourService;
    }

    public boolean submitGeneralCustomerQueryEmailToExecutive(QueryDto queryDto) {
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Customer Query</h1><br><br><h3>Email id: " + queryDto.getEmail() + "</h3><br><h3>Mobile Number: " + queryDto.getPhone() + "</h3><br><br><hr><p>" + queryDto.getText() + "</p>";
        if (sendEmail(emailExecutiveId, queryDto.getSubject(), content)) {
            return sendCustomerQueryReceivedConfirmation(queryDto.getEmail(), queryDto.getName());
        }
        return false;
    }

    public boolean submitTourQueryEmailToExecutive(QueryDto queryDto) {
        TourEntity tourEntity = this.tourService.getTourById(queryDto.getTourId());
        String subject = "Customer Query For " + tourEntity.getName();
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Customer submitted a query</h1><br><br><h3>Email id: " + queryDto.getEmail() + "</h3><br><h3>Mobile Number: " + queryDto.getPhone() + "</h3><br><br><hr><p>Customer is interested in Tour <b>" + tourEntity.getName() + "</b></p>";
        if (sendEmail(emailExecutiveId, subject, content)) {
            return sendCustomerEmailTourQueryConfirmation(queryDto.getEmail(), queryDto.getEmail(), tourEntity.getName());
        }
        return false;
    }

    public boolean submitCustomTourQueryEmailToExecutive(QueryDto queryDto) {
        String subject = "Customer Query For Custom Tours";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Customer submitted a query</h1><br><br>"
                + "<h3>Customer Name:</h3> "
                + queryDto.getName()
                + "<br><h3>Email id:</h3> "
                + queryDto.getEmail()
                + "<br><h3>Mobile Number: </h3>"
                + queryDto.getPhone()
                + "<br><h3>Country: </h3>"
                + queryDto.getCountry()
                + "<br><h3>Budget: </h3>" + queryDto.getBudgetSelection() + " "
                + queryDto.getBudget()
                + "<br><h3>Accommodation Type: </h3>"
                + queryDto.getAccommodation()
                + "<br><h3>Message: </h3>"
                + queryDto.getText()
                + "</p>";
        if (sendEmail(emailExecutiveId, subject, content)) {
            return sendCustomerCustomTourQueryConfirmation(queryDto.getEmail(), queryDto.getName());
        }
        return false;
    }

    public boolean submitCarRentalQueryEmailToExecutive(QueryDto queryDto) {
        String subject = "Customer Query For Car Rentals";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Customer submitted a query</h1><br><br>"
                + "<h3>Customer Name:</h3> "
                + queryDto.getName()
                + "<br><h3>Email id:</h3> "
                + queryDto.getEmail()
                + "<br><h3>Mobile Number: </h3>"
                + queryDto.getPhone()
                + "<br><h3>Interested in: </h3>"
                + queryDto.getSelectedCar()
                + "<br><h3>No of passenger: </h3>" + queryDto.getNumberOfPassenger() + " "
                + "<br><h3>Message: </h3>"
                + queryDto.getText()
                + "</p>";
        if (sendEmail(emailExecutiveId, subject, content)) {
            return sendCustomerCarRentalQueryConfirmation(queryDto.getEmail(), queryDto.getName());
        }
        return false;
    }

    private boolean sendCustomerCarRentalQueryConfirmation(String customerEmailId, String customerName) {
        String subject = "Received Query - The Indian Maharaja Tours";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Query Received</h1><br><br><p>Hi "
                + customerName
                + ",<br> Thanks for contacting us. Our customer care representative will contact you shortly with more details.<b>"
                + "</b>!</p>"
                + "<br><br>"
                + "<p>The Indian Maharaja Tours<br> j-10/87,<br> Rajouri Garden,<br> New Delhi-110027, India</p>";
        return sendEmail(customerEmailId, subject, content);
    }

    private boolean sendCustomerCustomTourQueryConfirmation(String customerEmailId, String customerName) {
        String subject = "Received Query - The Indian Maharaja Tours";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Query Received</h1><br><br><p>Hi "
                + customerName
                + ",<br> Thanks for contacting us. Our customer care representative will contact you shortly with more details.<b>"
                + "</b>!</p>"
                + "<br><br>"
                + "<p>The Indian Maharaja Tours<br> j-10/87,<br> Rajouri Garden,<br> New Delhi-110027, India</p>";
        return sendEmail(customerEmailId, subject, content);
    }

    private boolean sendCustomerEmailTourQueryConfirmation(String customerEmailId, String customerName, String tourName) {
        String subject = "Received Query - The Indian Maharaja Tours";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Query Received</h1><br><br><p>Hi " + customerName + ",<br> Thanks for contacting us. Our customer care representative will contact you shortly with more details about tour <b>" + tourName + "</b>!</p>"
                + "<br><br><p>The Indian Maharaja Tours<br> j-10/87,<br> Rajouri Garden,<br> New Delhi-110027, India</p>";
        return sendEmail(customerEmailId, subject, content);
    }

    private boolean sendCustomerQueryReceivedConfirmation(String customerEmailId, String customerName) {
        String subject = "The Indian Maharaja Tours";
        String content = "<img src='http://theindianmaharajatours.com/en/resources/theme/images/logo.png' width='201' height='86'/><br><h1>Customer Query Received</h1><br><br><p>Hi " + customerName + ",<br><br> Thanks for contacting us. Our customer care representative will contact you soon!</p><br><p>The Indian Maharaja Tours<br> 187/ A,<br> Rajouri Garden,<br> New Delhi, India</p>";
        return sendEmail(customerEmailId, subject, content);
    }

    private boolean sendEmail(String destinationEmail, String subject, String content) {

        Session session = getSession();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailExecutiveId));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationEmail));
            message.setSubject(subject);
            message.setContent(content, "text/html");
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailExecutiveId, emailExecutivePassword);
                    }
                });
    }
}
