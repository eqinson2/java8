package com.ericsson.eqinson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {


    public static void main(String[] args) throws IOException {
        //Pattern p = Pattern.compile(".+xml[\\r|\\n]+([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})");//. represents single character
        Pattern p = Pattern.compile("e_template.xml[\\r|\\n]*([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})");//. represents single character
//        Pattern p = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})");//. represents single character
//        Pattern p = Pattern.compile("e_template.xml([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})");//. represents single character

        byte[] encoded = Files.readAllBytes(Paths.get("my.log"));
        String str = new String(encoded, StandardCharsets.UTF_8);
        Matcher m = p.matcher(str);

        if (m.find()) {
            System.out.println("Found value 0: " + m.group(0));
            System.out.println("Found value 1: " + m.group(1));
//            System.out.println("Found value 1: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }
}
