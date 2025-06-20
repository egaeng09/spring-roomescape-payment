package roomescape.member.service;

import java.util.List;
import roomescape.member.auth.vo.MemberInfo;
import roomescape.member.controller.dto.MemberInfoResponse;
import roomescape.member.domain.Account;
import roomescape.member.domain.Member;

public class MemberConverter {

    public static MemberInfo toDto(Member member) {
        return new MemberInfo(
                member.getId(),
                member.getName().getValue(),
                member.getEmail().getValue(),
                member.getRole());
    }

    public static MemberInfo toDto(Account account) {
        return new MemberInfo(
                account.getMember().getId(),
                account.getMember().getName().getValue(),
                account.getMember().getEmail().getValue(),
                account.getMember().getRole());
    }

    public static MemberInfoResponse toResponse(MemberInfo memberInfo) {
        return new MemberInfoResponse(
                memberInfo.id(),
                memberInfo.name(),
                memberInfo.email()
        );
    }

    public static List<MemberInfoResponse> toResponses(List<MemberInfo> memberInfos) {
        return memberInfos.stream()
                .map(MemberConverter::toResponse)
                .toList();
    }
}
