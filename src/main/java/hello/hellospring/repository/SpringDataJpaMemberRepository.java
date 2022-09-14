package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스가 인터페이스를 받을 때는 implements 가 아니라 extends를 사용
// JpaRepository 를 받고 있으면 구현체를 자동으로 만들어줘서 스프링 빈에 등록해줌. 그럼 그것을 가져다 쓰면 됨
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // findBy~로 쿼리를 자동으로 작성해줌
}
