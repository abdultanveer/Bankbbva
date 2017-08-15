package abdul.poc.bbva.bankbbva.util;

import abdul.poc.bbva.bankbbva.model.BankLocation;

/**
 * Created by Ansari on 8/11/2017.
 */

public class Constants {
    public static String WEB_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=BBVA+Compass&location=42.5571574,-87.8361534&radius=10000&key=AIzaSyCii41i77gwaslCjKryxqJnC5bQRkwYweE";

    public static BankLocation[] BANK_LOCATIONS_TEST_DATA =
    {
            new BankLocation(42.5571574,-87.8361534,"2215 80th St, Kenosha, WI 53143, United States"),
            new BankLocation(42.5571574,-87.8361534,  "2215 80th St, Kenosha, WI 53143, United States"),
            new BankLocation(42.6304929,-87.8440315, "2801 14th Pl, Kenosha, WI 53140, United States"),
            new BankLocation(42.69604089999999,-87.87040650000002 , "3047 Oakes Rd, Mt Pleasant, WI 53177, United States"),
            new BankLocation(42.7858457,-87.80718279999999 , "5111 Douglas Ave, Racine, WI 53402, United States"),
            new BankLocation(42.91452,-87.883624,   "2201 E Rawson Ave, Oak Creek, WI 53154, United States"),
            new BankLocation(42.7034715,-88.25409450000001, "1901 Milwaukee Ave, Burlington, WI 53105, United States"),
            new BankLocation(42.975171,-88.1070544, "15445 W National Ave, New Berlin, WI 53151, United States"),
            new BankLocation(43.0261557,-87.9463935,"524 S Layton Blvd, Milwaukee, WI 53215, United States"),
            new BankLocation(43.0383653,-87.9121076, "161 W Wisconsin Ave #54, Milwaukee, WI 53203, United States"),
            new BankLocation(43.04644500000001,-87.99565299999999,"6700 W State St, Wauwatosa, WI 53213, United States"),
            new BankLocation(43.1061049,-88.01665349999999,"8340 W Appleton Ave, Milwaukee, WI 53218, United States"),
            new BankLocation(42.5911729,-88.41167879999999,"201 Edwards Blvd, Lake Geneva, WI 53147, United States"),
    };





}
