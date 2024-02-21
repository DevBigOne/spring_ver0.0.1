package hello.hellospring.domain;

public class Member {
    private Long id; //고객이 정하는 아이디가 아니라 시스템에서 쓸 임시의 값입니다.
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
