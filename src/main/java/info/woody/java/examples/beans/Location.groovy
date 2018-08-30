package info.woody.java.examples.beans

class Location {
    int id
    static class City extends Location {
        District district1
        District district2
        District district3
    }

    static class District extends Location {
        List<Road> roads
    }

    static class Road extends Location {
        List<Community> communities
        Street street1
        Street street2
        Street street3
    }

    static class Street extends Location {
        List<Community> communities
        List<Building> buildings
    }

    static class Community {
        Building building1
        Building building2
        Building building3
    }

    static class Building extends Location {
        List<Unit> units
    }

    static class Unit extends Location {
        List<Floor> floors
    }

    static class Floor extends Location {
        Room room1
        Room room2
    }

    static class Room extends Location {
        int number
    }

    static void main(String[] args) {

        // find from a city list where it has a leaf node of room type, which number 110
        List<City> cities
        List paths = "initial.cities.district1.roads.street3.communities.building3.units.floors.room2.number".split(/[.]/)
        int size = paths.size()
        (0..(size - 2))
                .eachWithIndex { it, i -> if (i) println "Closure<Boolean> ${paths[i]}Predication = { ChangeTypeHere it -> true }" }
                .eachWithIndex { it, i -> println "flatListOf(each${paths[i].capitalize()}.${paths[i + 1]}).findAll(${paths[i + 1]}Predication).each { each${paths[i + 1].capitalize()} -> " }
                .each { print(" }") }
    }

    static List flatListOf(e) { [e].findAll { e }.flatten() }
}