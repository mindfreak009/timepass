package java_oca;

// Output:
//     [Ljava_oca.Planet;@4361bd48
//     java_oca.Planet@53bd815b
//     1

// Options:
// planets
// Earth
// 1

// [Ljava_oca.Planet;@4361bd48
// Earth
// 1

// [Ljava_oca.Planet;@4361bd48
// Venus
// 0

class Planet {
    public String name;
    public int moons;

    public Planet(String name, int moons) {
        this.name = name;
        this.moons = moons;
    }
}


public class Ques59 {
    public static void main(String[] args) {
        Planet[] planets = {
                new Planet("Mercury", 0),
                new Planet("Venus", 0),
                new Planet("Earth", 1),
                new Planet("Mars", 2),
        };

        System.out.println(planets);
        System.out.println(planets[2]);
        System.out.println(planets[2].moons);
    }
}
