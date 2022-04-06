package htmlBuilders;

import java.util.Locale;

public class IndexBuilder {
    public static String build(String buttonLabel) {
        var path = buttonLabel.toLowerCase(Locale.ROOT);
        return "  <div class=\"w3-container\">\n" +
                "    <button class=\"w3-btn w3-green w3-hover-teal w3-round-xlarge w3-margin\" style=\"width:50%; height:50px;\" onclick=\"location.href='/"+path+"/list'\">"+ buttonLabel +"</button>\n" +
                "  </div>";
    }
}
