package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// Repository에서 데이터를 저장
// DB가 아닌 메모리에 저장하는 리포지토리
// 순수하게 자바로만 짠 것을 단위 테스트라 한다. 스프링, DB까지 연동하는 것이 통합테스트라 한다.
// 순수한 단위 테스트가 훨씬 좋은 테스트라 할 수 있다. 스프링 컨테이너 없이 테스트 하는 것을 연습해야 한다.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 아이디 셋팅
        store.put(member.getId(), member); // map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
