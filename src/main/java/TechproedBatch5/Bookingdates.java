package TechproedBatch5;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bookingdates {
    @JsonProperty("checkin")
    private String checkin;
    @JsonProperty("checkout")
    private String checkout;

    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }

    @JsonProperty("checkin")
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }

    @JsonProperty("checkout")
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public Bookingdates() {

    }

    public Bookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }


/*  Her variable icin mutlak getter ve setter olmali
POJO olmasi gerekenler
1)Json'dan key olanlar icin variable olusturun ve bu variablelarin access modifierlari "private" olmalidir.
2)Her variable icin mutlak getter ve setter olmalidir.
3)Parametresiz constructor olmalidir.
4)Olusturdugunuz variable icin parametreli constructorlari olusturalim.
5)toString() methodu olusturun

 */


}
