package models;

import lombok.*;

@Getter
@Builder
public class TestCaseLombokBuilder {
    //1. описание приватных переменных, которые нужны в этой сущности

    @NonNull
    String title;
    @Builder.Default
    int estimate = 5;

    String reference;
}
