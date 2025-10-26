package com.example.hot;

import java.util.Collections;
import java.util.LinkedList;

public class Demo394 {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {

                stk.addLast(getDigits(s));
            } else if ('[' == cur || Character.isLetter(cur)) {
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();

                while (!"[".equals(stk.peekLast())) {
                    sub.add(stk.removeLast());
                }

                Collections.reverse(sub);
                stk.removeLast();

                int num = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while (num-- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }

        }

        return getString(stk);

    }

    public String getDigits(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            stringBuffer.append(s.charAt(ptr++));
        }
        return stringBuffer.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


}
