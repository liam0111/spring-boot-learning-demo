package com.liam.springboot.restful.repository;

import com.liam.springboot.restful.model.Message;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/22 16:35
 */
public interface MessageRepository {
    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);
}
