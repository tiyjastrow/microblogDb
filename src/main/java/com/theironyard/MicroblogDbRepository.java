package com.theironyard;


import org.springframework.data.repository.CrudRepository;

public interface MicroblogDbRepository extends CrudRepository<Message, Integer>{

}
