package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;

    @NotEmpty(message = "도시는 필수 입니다.")
    private String city;

    @NotEmpty(message = "도로 주소는 필수 입니다.")
    private String street;

    @NotEmpty(message = "우편번호는 필수 입니다.")
    private String zipcode;


    public MemberForm() {
    }

    public MemberForm(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
