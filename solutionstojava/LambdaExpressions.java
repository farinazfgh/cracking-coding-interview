package solutionstojava;

import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressions {
    /*
        Lambda Expressions: There is a class Country that has methods getContinent () and
        getPopulation() . Write a function int getPopulation(List<Country> countries,
        String continent) that computes the total population of a given continent, given a list of all
        countries and the name of a continent.
     */
    static class Country {
        final String continent;
        final int population;

        String getContinent() {
            return continent;
        }

        public Country(String continent, int population) {
            this.continent = continent;
            this.population = population;
        }

        int getPopulation() {
            return population;
        }
    }

    int getPopulation(List<Country> countries, String continent) {
        int population = 0;
        for (Country country : countries) {
            if (country.getContinent().equals(continent)) population += country.getPopulation();
        }
        return population;
    }

    int getPopulationWithLambda(List<Country> countries, String continent) {
        Stream<Country> northAmerica = countries.stream().filter(country -> {
            return country.getContinent().equals(continent);
        });

        Stream<Integer> populations = northAmerica.map(country -> country.getPopulation());
        int population = populations.reduce(0, (a, b) -> a + b);

        return population;
    }

    int getPopulation3(List<Country> countries, String continent) {
        return countries.stream().filter(country -> {
            return country.getContinent().equals(continent);
        }).map(country -> country.getPopulation()).reduce(0, (a, b) -> a + b);
    }

    int getPopulationMethodRefrence(List<Country> countries, String continent) {
        return countries
                .stream()
                .filter(country -> country.getContinent().equals(continent))
                .map(Country::getPopulation)
                .reduce(0, Integer::sum);
    }
}
