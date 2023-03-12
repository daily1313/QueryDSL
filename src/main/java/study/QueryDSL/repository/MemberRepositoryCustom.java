package study.QueryDSL.repository;

import java.util.List;
import study.QueryDSL.dto.MemberSearchCondition;
import study.QueryDSL.dto.MemberTeamDto;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
}
