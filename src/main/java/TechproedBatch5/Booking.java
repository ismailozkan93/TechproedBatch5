package TechproedBatch5;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Booking {
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("totalprice")
    private int totalprice;
    @JsonProperty("depositpaid")
    private boolean depositpaid;
    @JsonProperty("bookingdates")
    private Bookingdates bookingdates;
    @JsonProperty("addionalneeds")
    private String addionalneeds;

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("totalprice")
    public int getTotalprice() {
        return totalprice;
    }

    @JsonProperty("totalprice")
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @JsonProperty("depositpaid")
    public boolean getDepositpaid() {
        return depositpaid;
    }

    @JsonProperty("depositpaid")
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    @JsonProperty("bookingdates")
    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    @JsonProperty("bookingdates")
    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    @JsonProperty("addionalneeds")
    public String getAddionalneeds() {
        return addionalneeds;
    }

    @JsonProperty("addionalneeds")
    public void setAddionalneeds(String addionalneeds) {
        this.addionalneeds = addionalneeds;
    }

    public Booking() {
    }

    public Booking(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Bookingdates bookingdates, String addionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.addionalneeds = addionalneeds;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", depositpaid='" + depositpaid + '\'' +
                ", bookingdates=" + bookingdates +
                ", addionalneeds='" + addionalneeds + '\'' +
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
