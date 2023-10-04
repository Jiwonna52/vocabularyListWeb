package NJWproject.vocabularyListWeb.member;

import NJWproject.vocabularyListWeb.entity.Member;
import NJWproject.vocabularyListWeb.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback
    public void testMember() {
        Member member = new Member();
        member.setName("A");
        Long savedId = memberRepository.save(member);

        Member findMember = memberRepository.find(savedId);
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }
}
