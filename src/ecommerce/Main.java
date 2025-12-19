package ecommerce;

interface IMessageService {
    void sendMessage(String message);
}

class EmailService implements IMessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email жіберу: " + message);
    }
}

class SMSService implements IMessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS жіберу: " + message);
    }
}

class NotificationManager {
    private IMessageService messageService;

    public NotificationManager(IMessageService messageService) {
        this.messageService = messageService;
    }

    public void notify(String message) {
        messageService.sendMessage(message);
    }
}

public class Main {
    public static void main(String[] args) {
        IMessageService emailService = new EmailService();
        NotificationManager manager = new NotificationManager(emailService);
        manager.notify("Сәлем, әлем!");

        IMessageService smsService = new SMSService();
        NotificationManager manager2 = new NotificationManager(smsService);
        manager2.notify("Сәлем, әлем!");
    }
}
