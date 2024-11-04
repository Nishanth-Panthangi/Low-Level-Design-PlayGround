import java.util.*;
import java.util.stream.Collectors;

/**
 * Example usage of the movie recommender system.
 */
public class Main {
    public static void main(String[] args) {
        // Create some actors
        Actor actor1 = new Actor("Actor One");
        Actor actor2 = new Actor("Actor Two");
        Actor actor3 = new Actor("Actor Three");
        Actor actor4 = new Actor("Actor Four");

        // Create some movies
        Movie movie1 = new Movie("Movie One", Arrays.asList(actor1, actor2));
        Movie movie2 = new Movie("Movie Two", Arrays.asList(actor2, actor3));
        Movie movie3 = new Movie("Movie Three", Arrays.asList(actor3, actor4));
        Movie movie4 = new Movie("Movie Four", Arrays.asList(actor1, actor4));
        Movie movie5 = new Movie("Movie Five", Arrays.asList(actor1, actor3));

        // All movies available in the system
        List<Movie> allMovies = Arrays.asList(movie1, movie2, movie3, movie4, movie5);

        // Users with their watch histories
        User user1 = new User("User One", Arrays.asList(movie1, movie3));
        User user2 = new User("User Two", Arrays.asList(movie2, movie3, movie5));
        User user3 = new User("User Three", Arrays.asList(movie1, movie2, movie4));
        User user4 = new User("User Four", Arrays.asList(movie2, movie5));
        User user5 = new User("User Five", Arrays.asList(movie3, movie4));

        // All users in the system
        List<User> allUsers = Arrays.asList(user1, user2, user3, user4, user5);

        // The user for whom we want to get recommendations
        User currentUser = new User("Current User", Arrays.asList(movie1));

        // Initialize the recommender system
        RecommenderSystem recommender = new RecommenderSystem(allMovies, allUsers);

        // Get recommendations
        List<Movie> recommendations = recommender.getRecommendations(currentUser);

        // Display recommendations
        System.out.println("Recommended Movies:");
        for (Movie movie : recommendations) {
            System.out.println(movie.getTitle());
        }
    }

    /**
     * Represents an actor with a name.
     */
    static class Actor {
        private String name;

        public Actor(String name) {
            this.name = name;
        }

        // Getter
        public String getName() {
            return name;
        }

        // Override equals and hashCode for proper functioning in HashMaps and HashSets
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Actor) {
                Actor other = (Actor) obj;
                return Objects.equals(name, other.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    /**
     * Represents a movie with a title and a list of actors.
     */
    static class Movie {
        private String title;
        private List<Actor> actors;

        public Movie(String title, List<Actor> actors) {
            this.title = title;
            this.actors = actors;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public List<Actor> getActors() {
            return actors;
        }
    }

    /**
     * Represents a user with a name and a watch history of movies.
     */
    static class User {
        private String name;
        private List<Movie> watchHistory;

        public User(String name, List<Movie> watchHistory) {
            this.name = name;
            this.watchHistory = watchHistory;
        }

        // Getters
        public String getName() {
            return name;
        }

        public List<Movie> getWatchHistory() {
            return watchHistory;
        }
    }

    /**
     * The recommender system that generates movie recommendations based on actor popularity.
     */
    static class RecommenderSystem {
        private List<Movie> allMovies;
        private List<User> allUsers;

        public RecommenderSystem(List<Movie> allMovies, List<User> allUsers) {
            this.allMovies = allMovies;
            this.allUsers = allUsers;
        }

        /**
         * Computes the popularity scores for all actors based on users' watch histories.
         *
         * @return A map of actors to their computed popularity scores.
         */
        private Map<Actor, Double> computeActorPopularityScores() {
            Map<Actor, Double> actorPopularityScores = new HashMap<>();

            for (User user : allUsers) {
                for (Movie movie : user.getWatchHistory()) {
                    for (Actor actor : movie.getActors()) {
                        actorPopularityScores.put(actor, actorPopularityScores.getOrDefault(actor, 0.0) + 1);
                    }
                }
            }

            return actorPopularityScores;
        }

        /**
         * Generates a list of recommended movies for a user based on actor popularity.
         *
         * @param user The user for whom to generate recommendations.
         * @return A list of recommended movies.
         */
        public List<Movie> getRecommendations(User user) {
            // Compute actor popularity scores
            Map<Actor, Double> actorPopularityScores = computeActorPopularityScores();

            // Create a set of watched movies for quick lookup
            Set<String> watchedMovieTitles = user.getWatchHistory()
                                                 .stream()
                                                 .map(Movie::getTitle)
                                                 .collect(Collectors.toSet());

            // Filter out movies already watched
            List<Movie> unwatchedMovies = allMovies.stream()
                    .filter(movie -> !watchedMovieTitles.contains(movie.getTitle()))
                    .collect(Collectors.toList());

            // Compute the popularity score for each unwatched movie
            Map<Movie, Double> movieScores = new HashMap<>();
            for (Movie movie : unwatchedMovies) {
                double score = movie.getActors()
                                    .stream()
                                    .mapToDouble(actor -> actorPopularityScores.getOrDefault(actor, 0.0))
                                    .sum();
                movieScores.put(movie, score);
            }

            // Sort the movies based on the computed scores in descending order
            List<Movie> recommendedMovies = movieScores.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Movie, Double>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            return recommendedMovies;
        }
    }
}
