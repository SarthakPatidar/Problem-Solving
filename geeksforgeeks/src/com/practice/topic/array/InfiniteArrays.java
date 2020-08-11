package com.practice.topic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class InfiniteArrays {
  public static int mod = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int T = Integer.parseInt(br.readLine().trim());
    for (int t_i = 0; t_i < T; t_i++) {
      int N = Integer.parseInt(br.readLine().trim());
      String[] arr_A = br.readLine().split(" ");
      int[] A = new int[N];
      for (int i_A = 0; i_A < arr_A.length; i_A++) {
        A[i_A] = Integer.parseInt(arr_A[i_A]);
      }

      int Q = Integer.parseInt(br.readLine().trim());
      String[] arr_L = br.readLine().split(" ");
      long[] L = new long[Q];
      for (int i_L = 0; i_L < arr_L.length; i_L++) {
        L[i_L] = Long.parseLong(arr_L[i_L]);
      }

      String[] arr_R = br.readLine().split(" ");
      long[] R = new long[Q];
      for (int i_R = 0; i_R < arr_R.length; i_R++) {
        R[i_R] = Long.parseLong(arr_R[i_R]);
      }

      long[] out_ = solve(A, R, L);
      System.out.print(out_[0]);
      for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
        System.out.print(" " + out_[i_out_]);
      }
      System.out.println("");
    }

    wr.close();
    br.close();
  }

  static long[] solve(int[] A, long[] R, long[] L) {
    // write your code here
    int n = A.length;
    int q = R.length;
    long[] sum = new long[n+1];
    long[] result = new long[q];
    sum[0] = 0;

    for (int i = 0; i < n; i++)
      sum[i+1] = sum[i] + A[i];

    for (int index = 0; index < q; index++) {
      BigInteger lSum = sumUtil(sum, L[index]-1, n);
      BigInteger rSum = sumUtil(sum, R[index], n);
      result[index] = rSum.subtract(lSum).mod(new BigInteger(String.valueOf(mod))).longValue();
    }

    return result;
  }

  private static BigInteger sumUtil(long[] sum, long key, int n) {
    BigInteger ans = BigInteger.valueOf(key/n);
    ans = ans.multiply( BigInteger.valueOf(sum[n]));
    ans = ans.add(BigInteger.valueOf(sum[(int)(key % n)]));
    return ans;
  }
}
