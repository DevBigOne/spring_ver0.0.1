package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Kimdaewon");

        repository.save(member);
        //Optional<Member> byId = repository.findById(member.getId());
        Member result1 = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result1); // 2개의 값이 같은지 확인
        assertThat(member).isEqualTo(result1); // member가 result1가 같은가 비교
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("kimdaewon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kimdaewon2");
        repository.save(member2);

        Member result = repository.findByName("kimdaewon1").get(); // 1에 대한 검증

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("kimdaewon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kimdaewon2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
