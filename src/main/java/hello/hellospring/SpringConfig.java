package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 직접 스프링 빈 등록하기
// 실무에서는 주로 정형화 된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용.
// 하지만 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
// Controller는 어쩔 수 없이 @Controller 애노테이션과 @Autowired해준다.
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 여기서 만약 DB와 연결된 리포지토리로 변경하려면 다른 코드를 건들이지 않고, return new DBMemberRepository로 바꿔주기만 하면 됨.
    }
}
