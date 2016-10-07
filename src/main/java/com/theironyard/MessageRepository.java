package com.theironyard;


import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    ArrayList<Message> findAllByOrderById();
}
