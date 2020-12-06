package models;

public class TestCase {
    //1. описание приватных переменных, которые нужны в этой сущности
    private String title;
    private int estimate;
    private String reference;
//3.Getters

    public String getTitle() {
        return title;
    }

    public int getEstimate() {
        return estimate;
    }

    public String getReference() {
        return reference;
    }

    //2.создать билдер
    public static class Builder {

        private TestCase newTestCase;
        //конструктор

        public Builder() {
            newTestCase = new TestCase();
        }

        //Setters
        public Builder withTitle(String title){
            newTestCase.title = title;
            return this;
        }
        public Builder withEstimate(int estimate){
            newTestCase.estimate = estimate;
            return this;
        }

        public Builder withReference(String reference){
            newTestCase.reference = reference;
            return this;
        }

       //метод build
        public TestCase build(){
            return newTestCase;
        }
    }
}
