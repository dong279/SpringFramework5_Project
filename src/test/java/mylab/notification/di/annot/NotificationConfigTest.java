package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	
	@Autowired
	NotificationManager notificationManger;
	
	@Test
	void testNotificationManger() {
		assertNotNull(notificationManger);
		
		EmailNotificationService emailService = (EmailNotificationService) notificationManger.getEmailService();
		assertNotNull(notificationManger.getEmailService());
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
		
		assertNotNull(notificationManger.getSmsService());
		SmsNotificationService smsService = (SmsNotificationService) notificationManger.getSmsService();
		assertEquals("SKT", smsService.getProvider());
		
		notificationManger.sendNotificationByEmail("테스트 이메일");
		notificationManger.sendNotificationBySms("테스트 SMS");
	}

}
