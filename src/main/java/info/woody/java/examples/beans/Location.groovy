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
                .eachWithIndex { it, i -> if (i) println "Closure<Boolean> ${paths[i]}Predication = { ${paths[i]} -> true }" }
                .eachWithIndex { it, i -> print "flatListOf(each${paths[i].capitalize()}.${paths[i + 1]})\n.findAll{ ${paths[i + 1]}Predication }\n.each { each${paths[i + 1].capitalize()} -> " }
                .each { print(" }") }
        Closure<Boolean> citiesPredication = { xcities -> xcities }
        Closure<Boolean> district1Predication = { district1 -> true }
        Closure<Boolean> roadsPredication = { roads -> true }
        Closure<Boolean> street3Predication = { street3 -> true }
        Closure<Boolean> communitiesPredication = { communities -> true }
        Closure<Boolean> building3Predication = { building3 -> true }
        Closure<Boolean> unitsPredication = { units -> true }
        Closure<Boolean> floorsPredication = { floors -> true }
        Closure<Boolean> room2Predication = { room2 -> true }
        flatListOf(cities)
                .findAll { citiesPredication }
                .each { eachCities ->
            flatListOf(eachCities.district1)
                    .findAll { district1Predication }
                    .each { eachDistrict1 ->
                flatListOf(eachDistrict1.roads)
                        .findAll { roadsPredication }
                        .each { eachRoads ->
                    flatListOf(eachRoads.street3)
                            .findAll { street3Predication }
                            .each { eachStreet3 ->
                        flatListOf(eachStreet3.communities)
                                .findAll { communitiesPredication }
                                .each { eachCommunities ->
                            flatListOf(eachCommunities.building3)
                                    .findAll { building3Predication }
                                    .each { eachBuilding3 ->
                                flatListOf(eachBuilding3.units)
                                        .findAll { unitsPredication }
                                        .each { eachUnits ->
                                    flatListOf(eachUnits.floors)
                                            .findAll { floorsPredication }
                                            .each { eachFloors ->
                                        flatListOf(eachFloors.room2)
                                                .findAll { room2Predication }
                                                .each { eachRoom2 ->
                                            flatListOf(eachRoom2.number)
                                                    .findAll { numberPredication }
                                                    .each { eachNumber -> }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static List flatListOf(e) { [e].findAll { e }.flatten() }
}