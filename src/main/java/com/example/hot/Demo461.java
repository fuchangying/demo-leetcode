package com.example.hot;

public class Demo461 {
    public int hammingDistance(int x, int y) {

        int t = x ^ y;
        int ret = 0;
        while (t != 0) {
            if ((t & 1) != 0) {
                ret++;
            }
            t=t>>1;
        }
        return ret;
    }
}
