// Live online course using Zoom
public class RealTimeRemoteCourse extends OnlineCourse {

    private String zoomInfo;

    public RealTimeRemoteCourse(String cNumber, int students, int max, int creds, String zoom) {
        super(cNumber, students, max, creds);
        zoomInfo = zoom;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDelivery: Real-Time Remote"
                + "\nZoom Info: " + zoomInfo;
    }
}
