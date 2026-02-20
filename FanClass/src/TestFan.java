public class TestFan {
   
	public static void main(String[] args) {

        // First fan
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(13);
        fan1.setColor("yellow");
        fan1.setOn(true);

        // Second fan
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5.554);
        fan2.setColor("red");
        fan2.setOn(false);

        // Display fans
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
