package com.theironyard;

import org.springframework.data.repository.CrudRepository;


/**
 * Created by EdHall on 10/5/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
