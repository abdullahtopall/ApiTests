package pojos.Herokuapp;

public class PojoHerokuappResponseBody {
    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingId) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public PojoHerokuappResponseBody(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerokuappResponseBody() {

    }

    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
