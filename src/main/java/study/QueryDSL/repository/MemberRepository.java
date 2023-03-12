package study.QueryDSL.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import study.QueryDSL.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    // select m from Member m where m.username = ?
    List<Member> findByUsername(String username);
}
