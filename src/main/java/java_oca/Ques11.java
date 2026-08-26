package java_oca;

interface Readable {
    public void readBook();
    public void setBookMark();
}

abstract class Book implements Readable {
    public void readBook() {}   // line n1
    // line n2
}

class EBook extends Book {    // line n3


    @Override
    public void readBook() {
        super.readBook();
    }

    // line n4
    @Override
    public void setBookMark() {

    }
}
public class Ques11 {
}
