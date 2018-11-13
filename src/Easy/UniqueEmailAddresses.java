package Easy;

import java.util.*;

public class UniqueEmailAddresses {
    private int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length < 1)
            return 0;

        Set<String> s = new HashSet<>();
        for(String e:emails){
            String[] temp = e.split("@");
            String local = temp[0];
            String domain = temp[1];
            if(local.contains("+")){
                local = local.substring(0, local.indexOf("+"));
            }

            local = local.replace(".", "");
            s.add(local + domain);
        }

        return s.size();
    }
}
