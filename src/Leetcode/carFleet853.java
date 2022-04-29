package Leetcode;

import java.util.Arrays;

public class carFleet853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; ++i)
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int ans = 0, t = N;
        //
        while (--t > 0) {
            if (cars[t].time < cars[t-1].time) ans++; //if cars[t] arrives sooner, it can't be caught
            else cars[t-1] = cars[t]; //else, cars[t-1] arrives at same time as cars[t]
        }

        return ans + (t == 0 ? 1 : 0); //lone car is fleet (if it exists)
    }


    public int carFleet1(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a.position, b.position) );

        int k = n, ans = 0;
        while(--k > 0) {
            if (cars[k].time < cars[k - 1].time) {
                ans++;
            } else {
                cars[k - 1] = cars[k];
            }
        }
        return ans +(k == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        carFleet853 carFleet853 = new carFleet853();
        carFleet853.carFleet1(100, new int[] {0,2,4}, new int[] {4,2,1});
    }



        class Car {
    int position;
    double time;

    Car(int p, double t) {
        position = p;
        time = t;
    }
}


}
