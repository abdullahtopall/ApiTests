package pojos.Dummy;

public class PojoDummyResponseBody {
    private String status;
    private PojoDummyDataResponse data;
    private String message;

    public PojoDummyResponseBody() {
    }

    public PojoDummyResponseBody(String status, String message, PojoDummyDataResponse data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyDataResponse getData() {
        return data;
    }

    public void setData(PojoDummyDataResponse data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PojoDummyResponseBody{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
