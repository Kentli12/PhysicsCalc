
import java.util.Scanner;
public class PhysicsCalculator {

    public PhysicsCalculator(){

    }
    public static double calculateVelocity(double distance, double time) {
        double velocity = distance/time;
        return velocity;
    }


    public static double calculateTime(double velocity, double distance) {
        double time = distance/velocity;
        return time;
    }


    public static double calculateDistance(double velocity, double time) {
        double distance = velocity * time;
        return distance;
    }


    public static double calculateFrequency(double period){
        return 1/period;
    }


    public static double calculatePeriod(double frequency){
        return 1/frequency;
    }



    public static double calculateWaveLength(double frequency,double velocity){
        return velocity/frequency;
    }


    public static double calculateFrequencyvelocity(double wavelength,double velocity){
        return velocity/wavelength;
    }


    public static double calculateCurrent(double resistance, double potentialDifference){
        return potentialDifference/resistance;
    }


    public static double calculateResistance(double resistivity, double length, double crossSectionalArea){
        return (resistivity*length)/crossSectionalArea;
    }
    public static double calculateEFS(double electrostaticForce, double charge){
        return electrostaticForce/charge;
    }
}

