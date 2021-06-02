package com.andreyzuenkov.mfm.repos;

import com.andreyzuenkov.mfm.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Integer> {
}
