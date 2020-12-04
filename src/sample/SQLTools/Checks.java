package sample.SQLTools;

import sample.system.SystemControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Checks {
    public static boolean checkNamePwd(String name, String password) {
        int s1 = name.length();
        int s2 = password.length();
        if (s1<6 || s1>20 || s2<6 || s2>20)
            return false;
        for (char c : name.toCharArray()) {
            if (c<'0' && c>'9' && c<'a' && c>'z')
                return false;
        }
        for (char c : password.toCharArray()) {
            if (c<'0' && c>'9' && c<'a' && c>'z')
                return false;
        }
        return true;
    }

    public static List<Integer> randomProbs() {
        List<Integer> res = new ArrayList<> ();
        Random r = new Random();
        int cal = r.nextInt(4);
        int a = 0, b = 0;
        System.out.println(cal);
        switch (cal) {
            case 0:
                a = r.nextInt(50);
                b = r.nextInt(50);
                break;
            case 1:
                a = r.nextInt(100);
                b = r.nextInt(100);
                break;
            case 2:
                a = r.nextInt(20);
                b = r.nextInt(20);
                break;
            case 3:
                a = r.nextInt(100);
                b = r.nextInt(20)+1;
                break;
            default:
                break;
        }
        res.add(cal);
        res.add(Math.max(a, b));
        res.add(Math.min(a, b));
        return res;
    }

    public static int verifyProbs(List<Integer> l) {
        int res = 0;
        int cal = l.get(0);
        int a = l.get(1);
        int b = l.get(2);
        switch (cal) {
            case 0:
                res = a+b;
                break;
            case 1:
                res = a-b;
                break;
            case 2:
                res = a*b;
                break;
            case 3:
                res = a/b;
                break;
            default:
                break;
        }
        return res;
    }
}
