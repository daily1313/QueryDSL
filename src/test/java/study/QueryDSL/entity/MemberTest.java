package study.QueryDSL.entity;


import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;

    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1",10, teamA);
        Member member2 = new Member("member2",20, teamA);

        Member member3 = new Member("member3",30, teamB);
        Member member4 = new Member("member4",40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        //초기화
        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member = " + member.getTeam());

        }
        // Member와 Team은 양방향 연관관계, Member.team 이 연관관계의 주인, Team.members 는 연관관계의 주인이 아님,
        // 따라서 Member.team 이 데이터베이스 외래키 값을 변경, 반대편은 읽기만 가능

    }
}