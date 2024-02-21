package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장하는 기능
    Optional<Member> findById(Long id); //저장소에서 찾는 기능 2가지
    //Optional은  findById가 그냥 가져온다면 NULL일 수 있기 때문에 Optional로 감싸서 반환이 가능하다.
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 회원 리스트를 찾는다.
}
