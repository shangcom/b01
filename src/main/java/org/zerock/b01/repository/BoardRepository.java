package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Board;
import org.zerock.b01.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    // JpaRepository 인터페이스 상속할 때는 엔티티 타입과 @Id 타입을 지정해줘야함.

    @Query(value="select now()", nativeQuery = true)
    String getTime();

}
