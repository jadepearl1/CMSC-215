package com.jadepearl;

public class Time implements Comparable<Time> {
    private final int hours;
    private final int minutes;
    private final String meridian;

    public Time(int hours, int minutes, String meridian) throws InvalidTime{
        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 59
        || (!meridian.equals("AM") && !meridian.equals("PM"))) {
            throw new InvalidTime("Invalid time components");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
    }

    public Time(String timeString) throws InvalidTime {
        String[] parts = timeString.split(":");
        if (parts.length != 2) {
            throw new InvalidTime("Invalid time format");
        }
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1].split(" ")[0]);
        String meridian = parts[1].split(" ")[1];
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 59
                || (!meridian.equals("AM") && !meridian.equals("PM"))) {
            throw new InvalidTime("Invalid time components");
        }
    }

    @Override
    public int compareTo(Time other) {
        if (meridian.equals("AM") && other.meridian.equals("PM")) {
            return -1;
        } else if (meridian.equals("PM") && other.meridian.equals("AM")) {
            return 1;
        } else {
            int hourComparison = Integer.compare(hours, other.hours);
            if (hourComparison != 0) {
                return hourComparison;
            }
            return Integer.compare(minutes, other.minutes);
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, meridian);
    }
    
}
