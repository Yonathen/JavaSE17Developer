public class TestInstanceOf {
  public static void openZoo(Object time) {
    if ( time instanceof Integer )
      System.out.println((Integer) time + " O'clock");
    else
      System.out.println(time);
  }

  public static void main(String[] args) {
    Integer zooTime = Integer.valueOf(9);

    Number num = zooTime;
    Object obj = zooTime;

    openZoo(zooTime);
    openZoo(num);
    openZoo(obj);
  }
}
