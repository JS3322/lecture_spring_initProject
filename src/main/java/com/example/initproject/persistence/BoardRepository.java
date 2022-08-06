package com.example.initproject.persistence;

import com.example.initproject.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository 제네릭 타입을 지정
public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword);
    List<Board> finByContentContaining(String searchKeyword);

}
