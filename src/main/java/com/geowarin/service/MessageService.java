package com.geowarin.service;

import com.geowarin.domain.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 31/01/2014
 * Time: 02:11
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Singleton
@Service
public class MessageService {
    List<Message> messages = Collections.synchronizedList(new ArrayList<Message>());

    @PostConstruct
    public void init() {
        messages.add(new Message("Joe", "Hello"));
        messages.add(new Message("Jane", "Spring boot is cool !"));
    }

    public List<Message> getMessages() {
        return messages;
    }
}
