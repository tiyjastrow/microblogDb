package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by BHarris on 3/8/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
