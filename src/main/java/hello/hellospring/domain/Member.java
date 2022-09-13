package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    // @Id : 기본키, @GeneratedValue(strategy = GenerationType.IDENTITY) : DB에서 자동으로 생성된다는 것을 명시
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//  @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
