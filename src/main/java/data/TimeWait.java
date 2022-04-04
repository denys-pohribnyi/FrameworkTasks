package data;

public enum TimeWait {
    TIME_WAIT_3(3),TIME_WAIT_5(5),TIME_WAIT_10(10);

    int value;

    TimeWait(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
