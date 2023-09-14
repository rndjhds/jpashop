package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookForm {

    private Long id;

    @NotEmpty(message = "책 이름은 필수로 입력해야 합니다.")
    private String name;

    @NotNull(message = "책 가격은 필수로 입력해야 합니다.")
    private Integer price;

    @NotNull(message = "책 재고는 필수로 입력해야 합니다.")
    private Integer stockQuantity;

    @NotEmpty(message = "책 저자는 필수로 입력해야 합니다.")
    private String author;

    @NotEmpty(message = "책 isbn은 필수로 입력해야 합니다.")
    private String isbn;

    public BookForm() {
    }

    public BookForm(Long id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
