package models;

import lombok.Data;

@Data
public class TestCaseLombok {
    //1. описание приватных переменных, которые нужны в этой сущности
    private String title;
    private int estimate;
    private String reference;

}
