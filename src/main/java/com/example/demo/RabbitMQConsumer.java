package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = "Mobile")
	public void getMessage(Person p) {
		System.out.println(p.getName());
	}

	/*
	 * @RabbitListener(queues = "Mobile") public void getMessage(byte[] message)
	 * throws IOException, ClassNotFoundException { ByteArrayInputStream bis = new
	 * ByteArrayInputStream(message); ObjectInput in = new ObjectInputStream(bis);
	 * Person p = (Person) in.readObject(); in.close(); bis.close();
	 * System.out.println(p.getName()); }
	 */

}
