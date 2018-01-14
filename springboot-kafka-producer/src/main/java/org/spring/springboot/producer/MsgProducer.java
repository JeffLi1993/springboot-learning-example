package org.spring.springboot.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Zephery
 * @since 2018/1/5 10:36
 */
@RestController
public class MsgProducer {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(MsgProducer.class);
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public void send(HttpServletRequest request) {
        String word = request.getParameter("word");
        kafkaTemplate.send("nginx-access-log", word);
    }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
    }
}