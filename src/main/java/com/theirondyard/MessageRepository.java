package com.theirondyard;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by joshuakeough on 10/5/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
