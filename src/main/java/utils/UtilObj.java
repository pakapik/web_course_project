package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class UtilObj {
    public String getResourceFileAsString(String fileName) {
        var is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is != null) {
            var reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    public StringBuilder getResourceFileAsStringBuilder(String fileName) throws IOException {
        try(var is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is != null) {
                var sb = new StringBuilder();
                String str;
                try(var reader = new BufferedReader(new InputStreamReader(is))) {
                    while((str=reader.readLine())!=null){
                        sb.append(str);
                    }
                }
                return sb;
            }
        }

        return null;
    }
}
