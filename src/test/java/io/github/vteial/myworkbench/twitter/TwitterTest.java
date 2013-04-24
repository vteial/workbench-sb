package io.github.vteial.myworkbench.twitter;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContextTest-twitter.xml" })
public class TwitterTest {

	@Autowired
	private TwitterTemplate twitterTemplate;

	@Autowired
	private MessageChannel twitterChannel;

	@Test
	public void testPostMessage() {
		String s = Calendar.getInstance().getTime()
				+ " @ New Message from Eialarasu using Spring Integration Module";
		Message<String> message = new GenericMessage<String>(s);

		//twitterChannel.send(message);
	}
}
