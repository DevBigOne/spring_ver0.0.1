package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,2 키 값을 자동으로 만들어준다.

    @Override
    public Member save(Member member) {
         member.setId(++sequence); //여기서 아이디에 대한 세팅을 한다.
         store.put(member.getId(), member); // store에 저장을 한다.
         return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 멤버 이름이 넘어와서 파라미터와 같은지 확인 같으면 필터링 작동
                .findAny();                                     // 찾으면 반환됨.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는게 멤버라서 확인 후 반환처리
    }

    public void clearStore() {
        store.clear(); // 비우는 명령어
    }
}
