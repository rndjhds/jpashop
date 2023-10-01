package jpabook.jpashop.api;

import jpabook.jpashop.member.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> memberV1() {
        List<Member> members = memberService.findMembers();
        return members;
    }

    // Result<T>로 감싸지 않으면 Json 배열로 넘어가기 때문에 다른 필요한 데이터(count...)를 넘기기 힘들다 떄문에 Json Array로 넘기지 않도록 해야한다.
    @GetMapping("/api/v2/members")
    public Result memberV2() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream().map(m -> new MemberDto(m.getUsername()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    static class MemberDto {
        private String name;

        public MemberDto(String name) {
            this.name = name;
        }
    }

    // 엔티티를 파라미터로 받는건 좋지 않다 엔티티의 스펙이 바뀌게 되면 api를 사용하는 모든곳에서 스펙이 변경되기 떄문에 별도의 dto를 만들어서 api를 만드는게 좋다
    // @Valid로 엔티티나 dto에서 설정한 @NotEmpty와 같은 설정을 가져올수 있다 가져와서 필요한 데이터에 대한 에러를 발생시켜서 필요한 데이터를 넘겨주도록 한다.
    // 엔티티를 리턴으로 반환해주는것은 좋지 않다. 불필요한 데이터도 무조건 넘겨줘야 하기 떄문이다.
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long memberId = memberService.join(member);
        return new CreateMemberResponse(memberId);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setUsername(request.getName());

        Long memberId = memberService.join(member);
        return new CreateMemberResponse(memberId);
    }

    @Data
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @PatchMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(
            @PathVariable("id") Long memberId,
            @RequestBody @Valid UpdateMemberRequest request) {

        memberService.update(memberId, request.getName());
        Member findMember = memberService.findOne(memberId);
        return new UpdateMemberResponse(findMember.getId(), findMember.getUsername());
    }

    @Data
    static class UpdateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }
}